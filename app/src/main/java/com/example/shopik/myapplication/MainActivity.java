package com.example.shopik.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import java.util.Random;

public class MainActivity extends AppCompatActivity implements iMainActivity {


    int number;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.button);

    }

    public MainActivity getActivity() {
        return this;
    }

    public int random() {
        Random random = new Random();
        number = (random.nextInt());
        return number;
    }

    public void refresh(View view) {
        TextView textView = (TextView) findViewById(R.id.text);
        number = random();
        ifVisible(number);
        textView.setText(String.valueOf(number));

    }

    public void ifVisible(int randomNumber) {
        if (randomNumber > 0) {
            button.setVisibility(View.VISIBLE);
        } else {
            button.setVisibility(View.INVISIBLE);
        }
    }

}
