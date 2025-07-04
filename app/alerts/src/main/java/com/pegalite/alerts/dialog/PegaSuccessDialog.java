package com.pegalite.alerts.dialog;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;

import com.pegalite.alerts.databinding.SuccessDialogBinding;
import com.pegalite.alerts.utils.DialogData;
import com.pegalite.alerts.utils.PegaFatherDialog;


public class PegaSuccessDialog extends PegaFatherDialog {

    Activity activity;

    public PegaSuccessDialog(Activity context, DialogData data) {
        super(context, data);
        activity = context;
    }

    public void show(String successMsg) {
        SuccessDialogBinding binding = SuccessDialogBinding.inflate(getActivityContext().getLayoutInflater());
        setContentView(binding.getRoot());
        binding.successMsg.setText(successMsg);
        binding.lottieAnimation.addAnimatorListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                dismiss();
            }
        });
        getDialog().setOnDismissListener(dialogInterface -> activity.finish());
        showPegaDialog();
    }
}
