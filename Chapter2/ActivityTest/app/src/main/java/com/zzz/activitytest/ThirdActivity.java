package com.zzz.activitytest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class ThirdActivity extends AppCompatActivity {

    private static final String TAG = "ThirdActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //打印返回栈的id
        Log.d(TAG, "onCreate: Task id is "+getTaskId());
        setContentView(R.layout.third_layout);
    }
}
