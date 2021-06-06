package com.example.lifecyclemvvmtest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    MyLocationListener myLocationListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myLocationListener = new MyLocationListener(new MyLocationListener.LocationListener() {
            @Override
            public void onUpdate(String location) {
                Log.i("MainActivity", "onUpdate: " + location);
            }
        });
        getLifecycle().addObserver(myLocationListener);

    }


//    @Override
//    public void onStart() {
//        super.onStart();
//        myLocationListener.start();
//    }
//
//    @Override
//    public void onStop() {
//        super.onStop();
//        myLocationListener.stop();
//    }
}