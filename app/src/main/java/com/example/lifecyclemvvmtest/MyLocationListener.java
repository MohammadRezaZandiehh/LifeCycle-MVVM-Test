package com.example.lifecyclemvvmtest;

import android.content.Context;
import android.location.LocationListener;

import java.util.Timer;
import java.util.TimerTask;

import javax.security.auth.callback.Callback;

class MyLocationListener {

    private Timer timer;

    private LocationListener locationListener;

    public MyLocationListener(LocationListener locationListener) {
        this.locationListener = locationListener;
    }

    void start() {
        // connect to system location service

        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                locationListener.onUpdate("Location " + System.currentTimeMillis());
            }
        }, 0, 1000);
    }

    void stop() {
        // disconnect from system location service

        timer.cancel();
        timer.purge();
        timer = null;
    }

    interface LocationListener {
        void onUpdate(String location);
    }
}