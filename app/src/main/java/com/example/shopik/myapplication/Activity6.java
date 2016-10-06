package com.example.shopik.myapplication;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Activity6 extends AppCompatActivity {

    SharedPreferences settings;
    public static final String PREFS_NAME = "MyPrefsFile";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_6);
    }
    public void onClick(View v) {
        settings = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();
        editor.clear();
        editor.apply();
    }
    @Override
    public void onBackPressed() {
        finishAffinity();
    }

}
