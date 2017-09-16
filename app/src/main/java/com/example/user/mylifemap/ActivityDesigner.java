package com.example.user.mylifemap;

import android.support.v7.app.ActionBar;
import android.app.Activity;
import android.os.Build;

/**
 * Created by user on 2017-09-16.
 */

public class ActivityDesigner {
    private Activity activity;
    private ActionBar actionBar;

    public ActivityDesigner(Activity activity, ActionBar actionBar) {
        this.activity = activity;
        this.actionBar = actionBar;
    }

    public void initalSettingforActivityDesign() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            activity.getWindow().setStatusBarColor(activity.getResources().getColor(R.color.colorBlack));//윈도우 색상 변경
            actionBar.setBackgroundDrawable(activity.getDrawable(R.color.colorBlack));//액션바 색상 변경
        }
    }
}
