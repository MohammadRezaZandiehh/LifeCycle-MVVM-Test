package com.example.lifecyclemvvmtest;

import android.content.Context;
import android.location.LocationListener;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.OnLifecycleEvent;

import java.util.Timer;
import java.util.TimerTask;

import javax.security.auth.callback.Callback;

class MyLocationListener {

    private Timer timer;
    private MutableLiveData<String> mutableLiveDataLocation = new MutableLiveData<>();

    public MyLocationListener() {
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                mutableLiveDataLocation.postValue("Location" + System.currentTimeMillis());
            }
        }, 0, 1000);
    }

    public MutableLiveData<String> getMutableLiveDataLocation() {
        return mutableLiveDataLocation;
    }
}