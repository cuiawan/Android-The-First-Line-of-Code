package com.zzz.activitytest;

import android.os.Bundle;
import android.util.Log;


import androidx.appcompat.app.AppCompatActivity;


public class BaseActivity extends AppCompatActivity {

    private static final String TAG="BaseActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //获取当前实例的类名
        Log.d(TAG, "onCreate: "+getClass().getSimpleName());

        //将正在创建的活动添加到活动管理器
        ActivityController.addActivity(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //将一个马上要销毁的活动从活动管理器中移除
        ActivityController.removeActivity(this);
    }
}
