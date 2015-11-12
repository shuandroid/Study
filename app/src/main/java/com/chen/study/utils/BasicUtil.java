package com.chen.study.utils;

import android.content.Context;
import android.widget.Toast;

import com.chen.study.R;

/**
 * Created by chen
 * Date : 15-11-13
 * Name : Study
 */
public class BasicUtil {

    public static void handleError(Context context, int error) {
        String tip = "Error";
        switch (error) {
            case 0:
                tip = context.getString(R.string.error_one);
                break;
            case 1:
                tip = context.getString(R.string.error_two);
                break;
            case 2:
                tip = context.getString(R.string.error_three);
        }

        Toast.makeText(context, tip, Toast.LENGTH_SHORT).show();
    }
}
