package com.example.lifecyclemvvmtest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    MyLocationListener myLocationListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myLocationListener = new MyLocationListener(this);
    }


    @Override
    public void onStart() {
        super.onStart();
        myLocationListener.start();
    }

    @Override
    public void onStop() {
        super.onStop();
        myLocationListener.stop();
    }
}