package com.example.user.mylifemap;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            getWindow().setStatusBarColor(getResources().getColor(R.color.colorBlack));//윈도우 색상 변경
            getSupportActionBar().setBackgroundDrawable(getDrawable(R.color.colorBlack));//액션바 색상 변경
        }
    }
}
