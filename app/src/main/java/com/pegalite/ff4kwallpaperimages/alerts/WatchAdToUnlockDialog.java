package com.pegalite.ff4kwallpaperimages.alerts;


import android.app.Activity;
import android.content.Intent;
import android.net.Uri;

import com.pegalite.alerts.utils.DialogData;
import com.pegalite.alerts.utils.PegaFatherDialog;
import com.pegalite.ff4kwallpaperimages.databinding.WatchAdToUnlockDialogBinding;

public class WatchAdToUnlockDialog extends PegaFatherDialog {

    public WatchAdToUnlockDialog(Activity context, DialogData data) {
        super(context, data);
    }

    public void show(Runnable runnable) {
        WatchAdToUnlockDialogBinding binding = WatchAdToUnlockDialogBinding.inflate(getActivityContext().getLayoutInflater());
        setContentView(binding.getRoot());

        binding.download.setOnClickListener(v -> {
            if (runnable != null) runnable.run();
            dismiss();
        });
        showPegaDialog();
    }

    private void update(String updateUrl) {
        getActivityContext().startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(updateUrl)));
    }

}
