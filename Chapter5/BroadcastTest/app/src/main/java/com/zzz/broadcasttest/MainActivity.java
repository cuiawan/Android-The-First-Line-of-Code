package com.zzz.broadcasttest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private IntentFilter intentFilter;

    private NetworkChangeReceiver networkChangeReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        networkChangeReceiver = new NetworkChangeReceiver();
        registerReceiver(networkChangeReceiver, intentFilter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(networkChangeReceiver);
    }

    class NetworkChangeReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            //方式一
//            Toast.makeText(context,"network changes",Toast.LENGTH_SHORT).show();

            //方式二
//            ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
//            NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
//            if (networkInfo != null && networkInfo.isAvailable()) {
//
//                Toast.makeText(context,"network is available",Toast.LENGTH_SHORT).show();
//
//            }else{
//                Toast.makeText(context,"network is unavailable",Toast.LENGTH_SHORT).show();
//            }

            //方式三
            //NetworkInfo 方法过时的处理方法
            ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
            if (connectivityManager != null) {
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
                    Network network = connectivityManager.getActiveNetwork();
                    NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(network);
                    if (networkCapabilities != null) {
                        if (networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI)) {
                            Toast.makeText(MainActivity.this, "WIFI", Toast.LENGTH_SHORT).show();
                        } else if (networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)) {
                            Toast.makeText(MainActivity.this, "流量", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(MainActivity.this, "没有网络", Toast.LENGTH_SHORT).show();
                    }

                }
            }
        }
    }
}