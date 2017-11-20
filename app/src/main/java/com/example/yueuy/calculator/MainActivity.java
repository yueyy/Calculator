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
    private float num1;
    private float num2;
    private float result;
    private EditText mEditText;
    private boolean num = true;
    private int flag = 0;

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
                if(result!=0){
                    result = num1;
                }else {
                    if (num) {
                        num1 = Float.parseFloat(mEditText.getText() + "");
                    } else {
                        num2 = Float.parseFloat(mEditText.getText() + "");
                    }
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
                if (num1!=0){
                    num = false;
                }else {
                    num = true;
                }
                switch (v.getId()){
                    case R.id.buttonPlus:
                        mEditText.setText("");
                        flag = 1;
                        break;
                    case R.id.buttonMinus:
                        mEditText.setText("");
                        flag = 2;
                        break;
                    case R.id.buttonMultiply:
                        mEditText.setText("");
                        flag = 3;
                        break;
                    case R.id.buttonDivide:
                        mEditText.setText("");
                        flag = 4;
                        break;
                }
            }
        };
        for (int id : operationalButton) {
            findViewById(id).setOnClickListener(listener);
        }

        findViewById(R.id.buttonEqual).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                switch (flag){
                    case 0:
                        break;
                    case 1:
                        result = num1 + num2;
                        break;
                    case 2:
                        result = num1 - num2;
                        break;
                    case 3:
                        result = num1 * num2;
                        break;
                    case 4:
                        result = num1 / num2;
                        break;
                    default:
                        break;
                }
                mEditText.setText("" + result);
            }
        });

        findViewById(R.id.buttonDelete).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num1 = 0;
                num2 = 0;
                mEditText.setText("");
            }
        });

    }
}

