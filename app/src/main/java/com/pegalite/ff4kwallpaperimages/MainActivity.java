package com.pegalite.ff4kwallpaperimages;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.ads.MobileAds;
import com.pegalite.ff4kwallpaperimages.ad.InterstitialAdManager;
import com.pegalite.ff4kwallpaperimages.databinding.ActivityMainBinding;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setStatusBar();

        MobileAds.initialize(this, initializationStatus -> {
        });

        InterstitialAdManager.loadAd(this);


        List<String> imageUrls = Arrays.asList(
                "https://drive.pegalite.com/api/shared/0f23338b-5ae6-4bda-949f-b4d3dd099467",
                "https://drive.pegalite.com/api/shared/9272e41b-38b3-4282-afa6-b7cbdccaaf6a",
                "https://drive.pegalite.com/api/shared/aaa7349e-0eac-4b1f-8824-d4c35eaa971f",
                "https://drive.pegalite.com/api/shared/a6635ce8-5577-44a8-bc14-9dc3a33814f8",
                "https://drive.pegalite.com/api/shared/8121cae7-a3e5-48a2-83e4-412a76c71958"
        );

        binding.recyclerView1.setHasFixedSize(true);
        binding.recyclerView1.setItemViewCacheSize(20); // Cache more views

        binding.recyclerView2.setHasFixedSize(true);
        binding.recyclerView2.setItemViewCacheSize(20); // Cache more views

        ImageAdapter adapter = new ImageAdapter(this, imageUrls.subList(0, imageUrls.size() / 2));
        adapter.setHasStableIds(true);
        binding.recyclerView1.setAdapter(adapter);

        ImageAdapter adapter2 = new ImageAdapter(this, imageUrls.subList(imageUrls.size() / 2, imageUrls.size()));
        adapter2.setHasStableIds(true);
        binding.recyclerView2.setAdapter(adapter2);

        boolean[] isSyncing = {false}; // Use array to access inside inner class

        binding.recyclerView1.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                if (!isSyncing[0]) {
                    isSyncing[0] = true;
                    binding.recyclerView2.scrollBy(dx, dy);
                    isSyncing[0] = false;
                }
            }
        });

        binding.recyclerView2.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                if (!isSyncing[0]) {
                    isSyncing[0] = true;
                    binding.recyclerView1.scrollBy(dx, dy);
                    isSyncing[0] = false;
                }
            }
        });
    }

    private void setStatusBar() {
        Window window = getWindow();
        Drawable background = ContextCompat.getDrawable(this, R.drawable.top_background);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(ContextCompat.getColor(this, android.R.color.transparent));
        window.setBackgroundDrawable(background);
        setSupportActionBar(binding.toolBar);
    }
}