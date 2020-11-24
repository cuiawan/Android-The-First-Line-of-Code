package com.zzz.mybroadcastreceiver2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class AnotherBroadcastReceive extends BroadcastReceiver {

    private static final String TAG = "AnotherBroadcastReceive";

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d(TAG, "onReceive: received in AnotherBoradcasrReceiver");
        Toast.makeText(context,"received in AnotherBoradcasrReceiver",Toast.LENGTH_SHORT).show();
    }
}
