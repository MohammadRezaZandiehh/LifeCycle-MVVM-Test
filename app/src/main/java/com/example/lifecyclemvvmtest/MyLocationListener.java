package com.example.lifecyclemvvmtest;

import android.content.Context;
import android.location.LocationListener;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.OnLifecycleEvent;

import java.util.Timer;
import java.util.TimerTask;

import javax.security.auth.callback.Callback;

class MyLocationListener implements LifecycleObserver {

    private Timer timer;

    private LocationListener locationListener;

    public MyLocationListener(LocationListener locationListener, Lifecycle lifecycle) {
        this.locationListener = locationListener;

        if (lifecycle.getCurrentState().isAtLeast(Lifecycle.State.CREATED)){
            // TODO: 8/19/2020
        }
    }


    @OnLifecycleEvent(value = Lifecycle.Event.ON_START)
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


    @OnLifecycleEvent(value = Lifecycle.Event.ON_STOP)
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