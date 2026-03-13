package com.pegalite.ff4kwallpaperimages.ad;

import android.app.Activity;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.rewarded.RewardItem;
import com.google.android.gms.ads.rewarded.RewardedAd;
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback;
import com.pegalite.alerts.dialog.PegaProgressDialog;
import com.pegalite.alerts.utils.DialogData;
import com.pegalite.ff4kwallpaperimages.R;

public class RewardedAdManager {
    private static RewardedAd rewardedAd;
    private static boolean isLoading = false;
    private static final String TAG = "RewardedAdManager";

    public interface RewardedCallback {
        void onUserEarnedReward(RewardItem reward);

        void onAdClosed(); // Called whether reward was earned or not
    }

    public static void loadAd(Activity activity) {
        if (rewardedAd != null || isLoading) return;

        isLoading = true;
        AdRequest adRequest = new AdRequest.Builder().build();

        RewardedAd.load(activity, activity.getString(R.string.rewarded_ad_id), adRequest, new RewardedAdLoadCallback() {
            @Override
            public void onAdLoaded(@NonNull RewardedAd ad) {
                rewardedAd = ad;
                isLoading = false;
                Log.d(TAG, "Rewarded ad loaded.");
            }

            @Override
            public void onAdFailedToLoad(@NonNull LoadAdError adError) {
                rewardedAd = null;
                isLoading = false;
                Log.e(TAG, "Failed to load rewarded ad: " + adError.getMessage());
            }
        });
    }

    public static void showAd(Activity activity, @Nullable RewardedCallback callback) {
        if (rewardedAd != null) {
            // Show ad immediately
            rewardedAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                @Override
                public void onAdDismissedFullScreenContent() {
                    rewardedAd = null;
                    loadAd(activity);
                    if (callback != null) callback.onAdClosed();
                }

                @Override
                public void onAdFailedToShowFullScreenContent(@NonNull com.google.android.gms.ads.AdError adError) {
                    rewardedAd = null;
                    loadAd(activity);
                    if (callback != null) callback.onAdClosed();
                }
            });

            rewardedAd.show(activity, rewardItem -> {
                if (callback != null) callback.onUserEarnedReward(rewardItem);
            });

        } else {
            // Show loading dialog while ad loads
            PegaProgressDialog dialog = new PegaProgressDialog(activity, DialogData.UN_CANCELABLE);
            dialog.show("Loading...");

            isLoading = true;
            AdRequest adRequest = new AdRequest.Builder().build();

            RewardedAd.load(activity, activity.getString(R.string.rewarded_ad_id), adRequest, new RewardedAdLoadCallback() {
                @Override
                public void onAdLoaded(@NonNull RewardedAd ad) {
                    rewardedAd = ad;
                    isLoading = false;
                    dialog.dismiss();

                    // Show the ad now
                    showAd(activity, callback);
                }

                @Override
                public void onAdFailedToLoad(@NonNull LoadAdError adError) {
                    rewardedAd = null;
                    isLoading = false;
                    dialog.dismiss();
                    Log.e(TAG, "Failed to load rewarded ad: " + adError.getMessage());
                    if (callback != null) callback.onAdClosed(); // fallback
                }
            });
        }
    }
}
