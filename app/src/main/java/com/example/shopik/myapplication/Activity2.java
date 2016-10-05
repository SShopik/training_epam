package com.example.shopik.myapplication;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Activity2 extends AppCompatActivity {

    SharedPreferences settings;
    public static final String PREFS_NAME = "MyPrefsFile";
    public static final String KEY_FOR_SAVE = "String_2";
    public static final String WAS_HERE = "ifEnd";
    EditText edit;
    Boolean was;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        edit = (EditText) findViewById(R.id.editText2);
        settings = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        edit.setText(settings.getString(KEY_FOR_SAVE,""));
        was = settings.getBoolean(WAS_HERE,false);
        if (was) {
            startActivity(new Intent(this, Activity6.class));
        }
    }
    public void onClick(View v){
        settings = getSharedPreferences(PREFS_NAME,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();
        editor.putString(KEY_FOR_SAVE,edit.getText().toString());
        editor.apply();
        startActivity(new Intent(this, Activity3.class));
    }
}
