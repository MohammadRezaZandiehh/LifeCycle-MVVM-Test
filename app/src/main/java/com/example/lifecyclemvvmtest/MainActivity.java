package com.example.lifecyclemvvmtest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    MyLocationListener myLocationListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myLocationListener = new ViewModelProvider(this).get(MyLocationListener.class);
        Log.i("hey you", "oncreate " + myLocationListener.getMutableLiveDataLocation().getValue());
        myLocationListener.getMutableLiveDataLocation().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                Log.i("MainActivity", "onChange" + s);
            }
        });
    }

}