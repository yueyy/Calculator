package com.example.yueuy.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import static android.R.attr.button;

public class MainActivity extends AppCompatActivity {

    private int[] numbericButton = {R.id.button0,R.id.button1,R.id.button1,R.id.button2,R.id.button3,R.id.button4,R.id.button5,R.id.button6,R.id.button7,R.id.button8,R.id.button9};
    private int[] calculateButton = {R.id.buttonDivide,R.id.buttonDot,R.id.buttonMinus,R.id.buttonEquals,R.id.buttonMultiply,R.id.buttonPercent,R.id.buttonPlus};
    private double valueNumber;
    private double valueNotNumber = Double.NaN;
    private boolean delete;
    private EditText mEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.mEditText = (EditText) findViewById(R.id.editText);
        setNumericOnClickListener();
        setCalculateOnClickListener();

    }

    private void setNumericOnClickListener(){
        View.OnClickListener listener = new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Button button = (Button) v;
                mEditText.setText(button.getText());
            }
        };
        for (int id : numbericButton) {
            findViewById(id).setOnClickListener(listener);
        }
    }

    private void setCalculateOnClickListener(){
        View.OnClickListener listener = new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Button button = (Button) v;

            }
        }
    }
}
