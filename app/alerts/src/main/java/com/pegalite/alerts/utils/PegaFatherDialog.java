package com.pegalite.alerts.utils;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.Window;

public class PegaFatherDialog {
    private final Activity context;
    private final DialogData data;
    private Dialog dialog;

    public PegaFatherDialog(Activity context, DialogData data) {
        this.context = context;
        this.data = data;
        onCreate();
    }

    private void onCreate() {
        dialog = new Dialog(context);
        Window window = dialog.getWindow();
        if (window != null) {
            window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        }
        if (data.equals(DialogData.FINISH_ON_CANCEL)) {
            dialog.setOnCancelListener(dialog -> {
                dismiss();
                context.finish();
            });
        } else if (data.equals(DialogData.UN_CANCELABLE)) {
            dialog.setCancelable(false);
        }

        dialog.create();
    }

    public void showPegaDialog() {
        dialog.show();
    }

    public void setContentView(View view) {
        dialog.setContentView(view);
    }

    public Activity getActivityContext() {
        return context;
    }

    public Dialog getDialog() {
        return dialog;
    }

    public boolean isShowing() {
        if (dialog == null) {
            return false;
        } else {
            return dialog.isShowing();
        }
    }

    public void dismiss() {
        if (isShowing()) {
            dialog.dismiss();
        }
    }
}
