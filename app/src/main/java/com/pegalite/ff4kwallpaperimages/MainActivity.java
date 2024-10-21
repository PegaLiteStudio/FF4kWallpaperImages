package com.pegalite.ff4kwallpaperimages;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

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

        List<String> imageUrls = Arrays.asList(
                "https://dl.dir.freefiremobile.com/common/web_event/official2.ff.garena.all/202210/82fe305f7dbb9f25e68996f8f719e576.jpg",
                "https://pxraja.com/wp-content/uploads/2024/06/free-fire-photo-1.webp",
                "https://dl.dir.freefiremobile.com/common/web_event/official2.ff.garena.all/202210/897ff6f29088b65b78d1d361d8d13ac4.jpg",
                "https://dl.dir.freefiremobile.com/common/web_event/official2.ff.garena.all/202210/c23d656a45bc5c75cd77d53065605fe0.jpg",
                "https://pxraja.com/wp-content/uploads/2024/06/free-fire-photo-4.webp",
                "https://dl.dir.freefiremobile.com/common/web_event/official2.ff.garena.all/202210/62107ecfbe289761d932a0c6fb134a91.jpg",
                "https://w0.peakpx.com/wallpaper/354/1008/HD-wallpaper-ff-fire-fire.jpg",
                "https://dl.dir.freefiremobile.com/common/web_event/official2.ff.garena.all/202210/2f81eaed8ecbc91322df8b5c417d1ab8.jpg",
                "https://dl.dir.freefiremobile.com/common/web_event/official2.ff.garena.all/202210/15e8936dbbf98b0f06e8a41bda47db1c.jpg",
                "https://pxraja.com/wp-content/uploads/2024/06/free-fire-photo-7.webp",
                "https://pxraja.com/wp-content/uploads/2024/06/free-fire-photo-8.webp",
                "https://w0.peakpx.com/wallpaper/534/367/HD-wallpaper-ff-hip-hop-bundle-hiphop-thunder-fire-game-thumbnail.jpg",
                "https://www.xtrafondos.com/thumbs/webp/1_8258.webp",
                "https://w0.peakpx.com/wallpaper/171/778/HD-wallpaper-ff-hip-hop-bundle-purple-flame-fire-hip-hop-bundle-game-thumbnail.jpg",
                "https://www.xtrafondos.com/thumbs/webp/1_3537.webp",
                "https://w0.peakpx.com/wallpaper/384/625/HD-wallpaper-ff-hip-hop-bundle-joker-fire-game-thumbnail.jpg",
                "https://www.91-cdn.com/hub/wp-content/uploads/2021/07/WhatsApp-Image-2021-07-29-at-5.13.21-PM-4.jpeg",
                "https://www.xtrafondos.com/thumbs/webp/1_6753.webp",
                "https://images5.alphacoders.com/133/thumb-1920-1331016.jpeg",
                "https://www.91-cdn.com/hub/wp-content/uploads/2021/07/2044720.jpg",
                "https://www.xtrafondos.com/thumbs/webp/1_6224.webp",
                "https://www.91-cdn.com/hub/wp-content/uploads/2021/07/2044720.jpg",
                "https://www.xtrafondos.com/thumbs/webp/1_6159.webp",
                "https://www.xtrafondos.com/wallpapers/resized/garena-free-fire-3257.jpg?s=large",
                "https://www.xtrafondos.com/thumbs/webp/1_8259.webp",
                "https://www.xtrafondos.com/thumbs/webp/1_3255.webp",
                "https://www.xtrafondos.com/thumbs/webp/1_8262.webp",
                "https://c4.wallpaperflare.com/wallpaper/521/153/310/video-game-garena-fire-wallpaper-preview.jpg",
                "https://wallpapercave.com/wp/wp6827098.jpg",
                "https://c4.wallpaperflare.com/wallpaper/946/656/907/weapons-attack-the-game-game-character-hd-wallpaper-preview.jpg",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS-ppXHpJ7pJa-Yauxgrv8IZVYtVXZ3HGb_Jg&s",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRR8r-gTONMnJcLfFtReNxuKuNJi_vlmEKpLA&s",
                "https://c4.wallpaperflare.com/wallpaper/12/111/787/blooming-meadows-boxes-with-cartridges-blooming-meadows-school-uniform-character-hd-wallpaper-preview.jpg",
                "https://c4.wallpaperflare.com/wallpaper/254/937/298/city-the-city-weapons-the-game-game-hd-wallpaper-preview.jpg",
                "https://wallpapercave.com/wp/wp5253203.jpg",
                "https://wallpapers.com/images/high/kelly-with-sniper-rifle-free-fire-desktop-pkfaf35alyimd7mr.webp",
                "https://wallpapers.com/images/high/free-fire-shani-k1v7fm5q4fmknczl.webp",
                "https://wallpapers.com/images/high/free-fire-dj-alok-blue-aesthetic-outfit-aw4u8uywvgp7s99d.webp",
                "https://wallpapers.com/images/high/free-fire-hayato-eealxw1pk679ajtd.webp",
                "https://wallpapers.com/images/high/glowing-blue-criminal-bundle-character-kobd4q9mgjeiskkp.webp",
                "https://wallpapers.com/images/high/free-fire-chrono-ei4as9anelibq1za.webp",
                "https://wallpapers.com/images/high/garena-free-fire-joker-character-jhs9545dgl11av65.webp",
                "https://wallpapers.com/images/high/maxim-free-fire-2020-5dzfi83vxkak4vpw.webp",
                "https://wallpapers.com/images/high/cherry-blossom-tree-and-mountain-free-fire-desktop-z311hxj1mq9eszp3.webp",
                "https://wallpapers.com/images/high/dashing-jai-free-fire-2020-3zsx8mv8inr2njbr.webp",
                "https://wallpapers.com/images/high/garena-on-a-perforated-hexagonal-patterns-t4iws2cwxjuqvvp2.webp",
                "https://wallpapers.com/images/high/garena-free-fire-notora-5yp3iwjycliel0h6.webp",
                "https://wallpapers.com/images/high/free-fire-hayato-alvaro-uky5volqz8vkvfei.webp",
                "https://wallpapers.com/images/high/free-fire-hayato-gaming-character-d9y1fvc3r48u3woc.webp",
                "https://wallpapers.com/images/high/free-fire-alok-in-game-character-hpnehln88akq891i.webp",
                "https://wallpapers.com/images/high/blue-criminal-bundle-with-grid-lines-pvsud22iydcqor7d.webp",
                "https://wallpapers.com/images/high/free-fire-desktop-crazy-clowns-ddly67s7jlsbgbl6.webp",
                "https://wallpapers.com/images/high/garena-free-fire-operation-chrono-r4avdu4dlq2852ej.webp",
                "https://wallpapers.com/images/high/free-fire-hayato-hayato-wolfrahh-gdmrk3i6le1h8zlm.webp",
                "https://wallpapers.com/images/high/free-fire-criminal-bundle-rare-gun-animal-57wdnayrqc2ydj7e.webp",
                "https://wallpapers.com/images/high/free-fire-criminal-bundle-christmas-criminals-ws0ex82hi9r5awxj.webp",
                "https://wallpapers.com/images/high/free-fire-ice-elves-i8rjbpyvxnpwfttj.webp",
                "https://wallpapers.com/images/high/free-fire-soldiers-in-dance-floor-desktop-hlq3vmpbar661vje.webp",
                "https://wallpapers.com/images/high/garena-free-fire-girl-dce0dzpwfsllz2r0.webp"

        );

        StaggeredGridLayoutManager staggeredGridLayoutManager =
                new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        staggeredGridLayoutManager.setGapStrategy(StaggeredGridLayoutManager.GAP_HANDLING_MOVE_ITEMS_BETWEEN_SPANS);

        binding.recyclerView.setLayoutManager(staggeredGridLayoutManager);
        binding.recyclerView.setHasFixedSize(true);
        binding.recyclerView.setItemViewCacheSize(20); // Cache more views

        ImageAdapter adapter = new ImageAdapter(this, imageUrls);
        adapter.setHasStableIds(true);
        binding.recyclerView.setAdapter(adapter);

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