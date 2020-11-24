package com.zzz.mybroadcastreceiver;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: ");
                Intent intent = new Intent("com.zzz.mybroadcastreceiver.MY_BROADCAST");
                intent.setComponent(new ComponentName("com.zzz.mybroadcastreceiver","com.zzz.mybroadcastreceiver.MyBroadcastReceiver"));
                sendBroadcast(intent);
            }
        });
    }
}
