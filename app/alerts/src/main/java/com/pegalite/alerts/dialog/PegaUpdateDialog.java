package com.pegalite.alerts.dialog;


import android.app.Activity;
import android.content.Intent;
import android.net.Uri;

import com.pegalite.alerts.databinding.UpdateDialogBinding;
import com.pegalite.alerts.utils.DialogData;
import com.pegalite.alerts.utils.PegaFatherDialog;

public class PegaUpdateDialog extends PegaFatherDialog {

    public PegaUpdateDialog(Activity context, DialogData data) {
        super(context, data);
    }


    public void show(String versionCode, String versionName, String updateUrl) {
        UpdateDialogBinding binding = UpdateDialogBinding.inflate(getActivityContext().getLayoutInflater());
        setContentView(binding.getRoot());

        binding.versionCode.setText(versionCode);
        binding.versionName.setText(versionName);
        binding.update.setOnClickListener(view -> update(updateUrl));
        showPegaDialog();
    }

    private void update(String updateUrl) {
        getActivityContext().startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(updateUrl)));
    }

}
