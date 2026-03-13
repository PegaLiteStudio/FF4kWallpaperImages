package com.pegalite.ff4kwallpaperimages.ad;

import android.app.Activity;
import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;
import com.pegalite.alerts.dialog.PegaProgressDialog;
import com.pegalite.alerts.utils.DialogData;
import com.pegalite.ff4kwallpaperimages.R;

public class InterstitialAdManager {
    private static InterstitialAd interstitialAd;
    private static boolean isLoading = false;
    private static final String TAG = "InterstitialAdManager";

    public static void loadAd(Context context) {
        if (interstitialAd != null || isLoading) return;

        isLoading = true;
        AdRequest adRequest = new AdRequest.Builder().build();

        InterstitialAd.load(context, context.getString(R.string.interstitial_ad_id), adRequest, new InterstitialAdLoadCallback() {
            @Override
            public void onAdLoaded(@NonNull InterstitialAd ad) {
                interstitialAd = ad;
                isLoading = false;
                Log.d(TAG, "Interstitial ad loaded");
            }

            @Override
            public void onAdFailedToLoad(@NonNull LoadAdError adError) {
                interstitialAd = null;
                isLoading = false;
                Log.e(TAG, "Interstitial ad failed to load: " + adError.getMessage());
            }
        });
    }

    public static void showAd(Activity activity, @Nullable Runnable onAdClosed) {
        if (interstitialAd != null) {
            interstitialAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                @Override
                public void onAdDismissedFullScreenContent() {
                    interstitialAd = null;
                    loadAd(activity.getApplicationContext());
                    if (onAdClosed != null) onAdClosed.run();
                }

                @Override
                public void onAdFailedToShowFullScreenContent(@NonNull com.google.android.gms.ads.AdError adError) {
                    interstitialAd = null;
                    loadAd(activity.getApplicationContext());
                    if (onAdClosed != null) onAdClosed.run();
                }
            });

            interstitialAd.show(activity);
        } else {
            // Show loading dialog while loading the ad
            PegaProgressDialog dialog = new PegaProgressDialog(activity, DialogData.UN_CANCELABLE);
            dialog.show("Loading...");

            isLoading = true;
            AdRequest adRequest = new AdRequest.Builder().build();

            InterstitialAd.load(activity, activity.getString(R.string.interstitial_ad_id), adRequest, new InterstitialAdLoadCallback() {
                @Override
                public void onAdLoaded(@NonNull InterstitialAd ad) {
                    interstitialAd = ad;
                    isLoading = false;
                    dialog.dismiss();
                    // Show the ad now
                    showAd(activity, onAdClosed);
                }

                @Override
                public void onAdFailedToLoad(@NonNull LoadAdError adError) {
                    interstitialAd = null;
                    isLoading = false;
                    Log.e(TAG, "Interstitial ad failed to load: " + adError.getMessage());
                    dialog.dismiss();
                    if (onAdClosed != null) onAdClosed.run(); // fallback
                }
            });
        }
    }
}
