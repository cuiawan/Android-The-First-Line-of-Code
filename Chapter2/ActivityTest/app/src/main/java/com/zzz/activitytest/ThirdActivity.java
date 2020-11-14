package com.zzz.activitytest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class ThirdActivity extends BaseActivity {

    private static final String TAG = "ThirdActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //打印返回栈的id
//        Log.d(TAG, "onCreate: Task id is "+getTaskId());
        setContentView(R.layout.third_layout);
        Button btn3 = (Button) findViewById(R.id.button_3);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityController.finishAll();
                //杀掉当前的进程
                android.os.Process.killProcess(android.os.Process.myPid());
            }
        });
    }
}
