package com.pegalite.alerts.dialog;


import android.app.Activity;

import com.pegalite.alerts.databinding.NoInternetDialogBinding;
import com.pegalite.alerts.utils.DialogData;
import com.pegalite.alerts.utils.PegaFatherDialog;

public class PegaNoInternetDialog extends PegaFatherDialog {

    public PegaNoInternetDialog(Activity context, DialogData data) {
        super(context, data);
    }

    public void show() {
        NoInternetDialogBinding binding = NoInternetDialogBinding.inflate(getActivityContext().getLayoutInflater());
        setContentView(binding.getRoot());

        showPegaDialog();
    }
}
