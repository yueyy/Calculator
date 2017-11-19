package com.example.yueuy.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import javax.xml.xpath.XPathExpression;

public class MainActivity extends AppCompatActivity {

    private int[] numbericButton = {R.id.buttonDot, R.id.button0, R.id.button1, R.id.button1, R.id.button2, R.id.button3, R.id.button4, R.id.button5, R.id.button6, R.id.button7, R.id.button8, R.id.button9};
    private int[] operationalButton = {R.id.buttonDivide, R.id.buttonMinus, R.id.buttonEqual, R.id.buttonMultiply, R.id.buttonPercent, R.id.buttonPlus};
    private String text1;
    private String text2;
    private float result;
    //    private boolean delete;
    private EditText mEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.mEditText = (EditText) findViewById(R.id.editText);
        setNumericOnClickListener();
        setOperationalOnClickListener();

    }

    private void setNumericOnClickListener() {
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.button0:
                        mEditText.append("0");
                        break;
                    case R.id.button1:
                        mEditText.append("1");
                        break;
                    case R.id.button2:
                        mEditText.append("2");
                        break;
                    case R.id.button3:
                        mEditText.append("3");
                        break;
                    case R.id.button4:
                        mEditText.append("4");
                        break;
                    case R.id.button5:
                        mEditText.append("5");
                        break;
                    case R.id.button6:
                        mEditText.append("6");
                        break;
                    case R.id.button7:
                        mEditText.append("7");
                        break;
                    case R.id.button8:
                        mEditText.append("8");
                        break;
                    case R.id.button9:
                        mEditText.append("9");
                        break;
                    case R.id.buttonDot:
                        mEditText.append(".");
                        break;
                }
            }
        };
        for (int id : numbericButton) {
            findViewById(id).setOnClickListener(listener);
        }
    }

    private void setOperationalOnClickListener() {
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.buttonMultiply:
                        text1 = mEditText.getText().toString();
                        mEditText.setText("");
                        break;
                    case R.id.buttonMinus:
                        text1 = mEditText.getText().toString();
                        mEditText.setText("");
                        break;
                    case R.id.buttonPlus:
                        text1 = mEditText.getText().toString();
                        mEditText.setText("");
                        break;
                    case R.id.buttonDivide:
                        text1 = mEditText.getText().toString();
                        mEditText.setText("");
                        break;
                    case R.id.buttonEqual:


                }
            }
        };
        for (int id : operationalButton) {
            findViewById(id).setOnClickListener(listener);
        }

        findViewById(R.id.buttonDelete).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mEditText.setText("");
            }
        });

    }
}

