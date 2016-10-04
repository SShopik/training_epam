package com.example.shopik.myapplication;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Activity5 extends AppCompatActivity {

    SharedPreferences settings;
    public static final String PREFS_NAME = "MyPrefsFile";
    public static final String KEY_FOR_SAVE = "String_5";
    public static final String WAS_HERE = "Activity_5";
    EditText edit;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_5);
        edit= (EditText) findViewById(R.id.editText5);
        settings = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        edit.setText(settings.getString(KEY_FOR_SAVE,""));
        Boolean was = settings.getBoolean(WAS_HERE,false);
        if (was) {
            button = (Button) findViewById(R.id.button_5);
            this.onClick(button);
        }
    }
    public void onClick(View v){
        settings = getSharedPreferences(PREFS_NAME,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();
        editor.putString(KEY_FOR_SAVE,edit.getText().toString());
        editor.putBoolean(WAS_HERE,true);
        editor.apply();

        startActivity(new Intent(this, Activity6.class).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK));
    }
}
