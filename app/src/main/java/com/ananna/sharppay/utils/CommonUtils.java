package com.ananna.sharppay.utils;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Point;
import android.os.Build;
import android.view.Display;

public class CommonUtils {
    public static int SCREEN_WIDTH ;
    public static int SCREEN_HEIGHT;

    public static void getScreen(Context context) {

        Display display = ((Activity) context).getWindowManager().getDefaultDisplay();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR2) {
            Point size = new Point();
            display.getSize(size);
            SCREEN_WIDTH = size.x;
            SCREEN_HEIGHT = size.y;
        } else {
            SCREEN_WIDTH = display.getWidth();
            SCREEN_HEIGHT = display.getHeight();
        }


    }


    public static void showAlert(Context context, String msg) {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(context);

        alertDialog.setTitle("Alert Message");
        alertDialog.setMessage(msg);

        alertDialog.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                dialog.cancel();
            }
        });
        alertDialog.show();
    }

    public static void showAlert(Context context, final String caption, final String msg) {
        final AlertDialog.Builder alertDialog = new AlertDialog.Builder(context);

        ((Activity) context).runOnUiThread(new Runnable() {
            @Override
            public void run() {
                alertDialog.setTitle(caption);
                alertDialog.setMessage(msg);

                alertDialog.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        dialog.cancel();
                    }
                });
                alertDialog.show();
            }
        });

    }



}
