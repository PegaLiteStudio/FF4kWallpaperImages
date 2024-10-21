package com.pegalite.ff4kwallpaperimages;

import android.app.ProgressDialog;
import android.app.WallpaperManager;
import android.content.ContentValues;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.pegalite.ff4kwallpaperimages.databinding.ActivityWallpaperBinding;
import com.pegalite.ff4kwallpaperimages.databinding.OptionBottomSheetBinding;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class WallpaperActivity extends AppCompatActivity {

    ActivityWallpaperBinding binding;

    private WallpaperManager wallpaperManager;
    private String IMAGE_URL;
    private static final int REQUEST_WRITE_PERMISSION = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityWallpaperBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(ContextCompat.getColor(this, R.color.prussian_blue));

        binding.back.setOnClickListener(view -> getOnBackPressedDispatcher().onBackPressed());

        IMAGE_URL = getIntent().getStringExtra("url");

        Picasso.get().load(IMAGE_URL).into(binding.wallpaper);

        wallpaperManager = WallpaperManager.getInstance(this);

        binding.share.setOnClickListener(view -> shareImageWithMessage());
        binding.download.setOnClickListener(view -> downloadImage());
        binding.setWallpaper.setOnClickListener(view -> {
            BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(this);
            OptionBottomSheetBinding bottomSheetBinding = OptionBottomSheetBinding.inflate(getLayoutInflater());
            bottomSheetBinding.bottomSheetContainer.setBackgroundColor(Color.TRANSPARENT);
            bottomSheetDialog.setContentView(bottomSheetBinding.getRoot());

            // For Home screen wallpaper
            bottomSheetBinding.homeScreen.setOnClickListener(v1 -> {
                setWallpaper(WallpaperManager.FLAG_SYSTEM);  // Set as home screen wallpaper
                bottomSheetDialog.cancel();
            });

            // For Lock screen wallpaper
            bottomSheetBinding.lockScreen.setOnClickListener(v1 -> {
                setWallpaper(WallpaperManager.FLAG_LOCK);  // Set as lock screen wallpaper
                bottomSheetDialog.cancel();
            });

            // For Both home and lock screen wallpaper
            bottomSheetBinding.homeAndLock.setOnClickListener(v1 -> {
                setWallpaper(WallpaperManager.FLAG_SYSTEM | WallpaperManager.FLAG_LOCK);  // Set as both home and lock screen wallpaper
                bottomSheetDialog.cancel();
            });

            bottomSheetDialog.show();
        });
    }


    /**
     * Check for storage write permission (for Android 9 and below)
     */
    private void checkStoragePermission() {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.Q) {
            if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.WRITE_EXTERNAL_STORAGE)
                    != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this,
                        new String[]{android.Manifest.permission.WRITE_EXTERNAL_STORAGE}, REQUEST_WRITE_PERMISSION);
            }
        }
    }

    // Handle permission request result
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_WRITE_PERMISSION) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, "Permission Granted!", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Permission Denied!", Toast.LENGTH_SHORT).show();
            }
        }
    }

    /**
     * Download and save image in Pictures Folder. For this we Don't Need permission above api 10;
     */
    private void downloadImage() {
        checkStoragePermission();
        Picasso.get().load(IMAGE_URL).into(new Target() {
            @Override
            public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
                try {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                        saveImageToMediaStore(bitmap);
                    } else {
                        saveImageToExternalStorage(bitmap);
                    }
                    Toast.makeText(WallpaperActivity.this, "Image saved successfully!", Toast.LENGTH_SHORT).show();
                } catch (IOException e) {
                    Toast.makeText(WallpaperActivity.this, "Failed to save image", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onBitmapFailed(Exception e, Drawable errorDrawable) {
                Toast.makeText(WallpaperActivity.this, "Failed to download image", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onPrepareLoad(Drawable placeHolderDrawable) {
                ProgressDialog progressDialog = new ProgressDialog(WallpaperActivity.this, R.drawable.dialog_rounded_corner);
                progressDialog.setTitle("Loading...");
                progressDialog.setMessage("Please Wait While Loading.");
                progressDialog.show();
            }
        });
    }

    /**
     * Save image in Pictures Folder. in Api 10+
     */
    private void saveImageToMediaStore(Bitmap bitmap) throws IOException {
        ContentValues values = new ContentValues();
        values.put(MediaStore.Images.Media.DISPLAY_NAME, "wallpaper_" + System.currentTimeMillis() + ".png");
        values.put(MediaStore.Images.Media.MIME_TYPE, "image/png");
        values.put(MediaStore.Images.Media.RELATIVE_PATH, "Pictures/Wallpapers");

        Uri uri = getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values);
        if (uri != null) {
            try (OutputStream outputStream = getContentResolver().openOutputStream(uri)) {
                if (outputStream != null) {
                    bitmap.compress(Bitmap.CompressFormat.PNG, 100, outputStream);
                }
            }
        }
    }


    /**
     * Create Folder and Save the image. Below Api 10;
     */
    private void saveImageToExternalStorage(Bitmap bitmap) throws IOException {
        File picturesDir = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES), "FF 4K Wallpaper Images");
        if (!picturesDir.exists()) {
            if (picturesDir.mkdirs()) {
                System.out.println("Directory Created!");
            }
        }

        File imageFile = new File(picturesDir, "wallpaper_" + System.currentTimeMillis() + ".png");

        try (FileOutputStream outputStream = new FileOutputStream(imageFile)) {
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, outputStream);
        }
    }

    /**
     * Saves the image in Cache Directory and Shares it With a message
     */
    private void shareImageWithMessage() {
        Picasso.get().load(IMAGE_URL).into(new Target() {
            @Override
            public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
                try {
                    Uri imageUri = saveImageToCache(bitmap);

                    if (imageUri != null) {
                        Intent shareIntent = new Intent(Intent.ACTION_SEND);
                        shareIntent.setType("image/*");
                        shareIntent.putExtra(Intent.EXTRA_STREAM, imageUri);
                        shareIntent.putExtra(Intent.EXTRA_TEXT, "Check out this awesome wallpaper!. To get More Wallpapers like this Download - https://play.google.com/store/apps/details?id=com.pegalite.ff4kwallpaperimages");
                        shareIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);

                        startActivity(Intent.createChooser(shareIntent, "Share Wallpaper"));
                    } else {
                        Toast.makeText(WallpaperActivity.this, "Failed to share image", Toast.LENGTH_SHORT).show();
                    }

                } catch (IOException e) {
                    Toast.makeText(WallpaperActivity.this, "Error saving image", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onBitmapFailed(Exception e, Drawable errorDrawable) {
                Toast.makeText(WallpaperActivity.this, "Failed to load image", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onPrepareLoad(Drawable placeHolderDrawable) {
                ProgressDialog progressDialog = new ProgressDialog(WallpaperActivity.this, R.drawable.dialog_rounded_corner);
                progressDialog.setTitle("Loading...");
                progressDialog.setMessage("Please Wait While Loading.");
                progressDialog.show();
            }
        });
    }

    /**
     * Saves image in cache Directory
     */
    private Uri saveImageToCache(Bitmap bitmap) throws IOException {
        File cachePath = new File(getCacheDir(), "images");
        if (!cachePath.exists()) {
            if (cachePath.mkdirs()) {
                System.out.println("Directory Created!");
            }
        }

        File imageFile = new File(cachePath, "shared_image_" + System.currentTimeMillis() + ".png");

        FileOutputStream outputStream = new FileOutputStream(imageFile);
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, outputStream);
        outputStream.flush();
        outputStream.close();

        return FileProvider.getUriForFile(this, getApplicationContext().getPackageName() + ".fileprovider", imageFile);
    }

    /**
     * Sets wallpaper Home/Lock Screen
     */
    private void setWallpaper(int flag) {

        // Load the image and set as wallpaper using Picasso
        Picasso.get().load(IMAGE_URL).into(new Target() {
            @Override
            public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
                try {
                    wallpaperManager.setBitmap(bitmap, null, true, flag);
                    Toast.makeText(WallpaperActivity.this, "Wallpaper set successfully", Toast.LENGTH_SHORT).show();
                } catch (IOException e) {
                    Toast.makeText(WallpaperActivity.this, "Failed to set wallpaper", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onBitmapFailed(Exception e, Drawable errorDrawable) {
                Toast.makeText(WallpaperActivity.this, "Failed to load image", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onPrepareLoad(Drawable placeHolderDrawable) {
                ProgressDialog progressDialog = new ProgressDialog(WallpaperActivity.this, R.drawable.dialog_rounded_corner);
                progressDialog.setTitle("Loading...");
                progressDialog.setMessage("Please Wait While Loading.");
                progressDialog.show();
            }
        });

    }
}