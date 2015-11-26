package com.hat.stock.Tools;

import android.app.Activity;
import android.app.Dialog;
import android.util.DisplayMetrics;
import android.view.WindowManager;

import com.hat.stock.R;

/**
 * Created by anting.hu on 2015/11/26.
 */
public class DialogUtils {

    public static WindowManager.LayoutParams createLayoutParams(Dialog dialog) {
        Activity context = dialog.getOwnerActivity();
        final DisplayMetrics metrics = context.getResources().getDisplayMetrics();
        final boolean isPortrait = metrics.widthPixels < metrics.heightPixels;

        float percent;
        if (isPortrait) {
            percent = context.getResources().getFraction(R.fraction.dialog_min_width_minor, 1, 1);
        } else {
            percent = context.getResources().getFraction(R.fraction.dialog_min_width_major, 1, 1);
        }
        int width = (int) (context.getResources().getDisplayMetrics().widthPixels * percent);

        WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
        lp.copyFrom(dialog.getWindow().getAttributes());
        lp.width = width;
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        return lp;
    }
}
