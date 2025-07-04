package com.pegalite.alerts.dialog;


import android.app.Activity;

import androidx.annotation.Nullable;

import com.pegalite.alerts.databinding.ProgressDialogBinding;
import com.pegalite.alerts.utils.DialogData;
import com.pegalite.alerts.utils.PegaFatherDialog;

public class PegaProgressDialog extends PegaFatherDialog {
    public PegaProgressDialog(Activity context, DialogData data) {
        super(context, data);
    }

    public void show() {
        show(null);
    }

    public void show(@Nullable String message) {
        ProgressDialogBinding binding = ProgressDialogBinding.inflate(getActivityContext().getLayoutInflater());
        setContentView(binding.getRoot());

        if (message != null) {
            binding.msg.setText(message);
        }

        showPegaDialog();
    }

}
