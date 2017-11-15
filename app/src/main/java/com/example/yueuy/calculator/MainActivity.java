package com.example.yueuy.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import static android.R.attr.button;

public class MainActivity extends AppCompatActivity {

    private int[] numbericButton = {R.id.button0,R.id.button1,R.id.button1,R.id.button2,R.id.button3,R.id.button4,R.id.button5,R.id.button6,R.id.button7,R.id.button8,R.id.button9}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        for (int i = 0; i < buttons.length; i++) {
//            temp = (Button) findViewById(button[i])
//        }
    }
}
