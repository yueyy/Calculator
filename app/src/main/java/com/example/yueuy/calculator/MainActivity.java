package com.example.yueuy.calculator;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import database.MyDBData.MyDataBaseHelper;

public class MainActivity extends AppCompatActivity {

    private int[] numericButton = { R.id.button0, R.id.button1, R.id.button1, R.id.button2, R.id.button3, R.id.button4, R.id.button5, R.id.button6, R.id.button7, R.id.button8, R.id.button9};
    private int[] operationalButton = {R.id.buttonDivide, R.id.buttonMinus, R.id.buttonEqual, R.id.buttonMultiply, R.id.buttonPlus, R.id.buttonDot, R.id.buttonPercent};
    private float num1;
    private float num2;
    public static float result;
    private String resultPast;
    private String resultNow;
    private EditText mEditText;
    private boolean num = true;
    private boolean mEqual=true;
    private boolean mOperation = true;
    private int flag = 0;

    private Context mContext;
    private SQLiteDatabase mDatabase;
    private MyDataBaseHelper myDBHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mEditText = (EditText) findViewById(R.id.editText);
        mEditText.setSelection(mEditText.getText().length());
        setNumericOnClickListener();
        setOperationalOnClickListener();
        setEqual();
        setClear();
        exception();

//        Button saveData = (Button) findViewById(R.id.btn_save);
//        saveData.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                SQLiteDatabase db = myDBHelper.getWritableDatabase();
//                ContentValues values = new ContentValues();
//                values.put("result", result);
//                db.insert("Data", null, values);
//                values.clear();
//            }
//        });

    }

    private void setNumericOnClickListener() {
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mEqual ){
                    mEditText.setText("");
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
                    }
                }
                if(result!=0){
                    result = num1;
                    num2 = 0;
                }else {
                    if (num) {
                        num1 = Float.parseFloat(mEditText.getText() + "");
                    } else {
                        num2 = Float.parseFloat(mEditText.getText() + "");
                    }
                }
            }
        };
        for (int id : numericButton) {
            findViewById(id).setOnClickListener(listener);
        }
    }

    private void setOperationalOnClickListener() {
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (num1 != 0) {
                    num = false;
                } else {
                    num = true;
                }
                if (num1 !=0 && num2 ==0 && mOperation) {
                    mEditText.setText("");
                    switch (v.getId()) {
                        case R.id.buttonPlus:
                            mEditText.setText("");
                            flag = 1;
                            mOperation = false;
                            break;
                        case R.id.buttonMinus:
                            mEditText.setText("");
                            flag = 2;
                            mOperation = false;
                            break;
                        case R.id.buttonMultiply:
                            mEditText.setText("");
                            flag = 3;
                            mOperation = false;
                            break;
                        case R.id.buttonDivide:
                            mEditText.setText("");
                            flag = 4;
                            mOperation = false;
                            break;
                        case R.id.buttonDot:
                            mEditText.append(".");
                            mOperation = false;
                            break;
                        case R.id.buttonPercent:
                            mEditText.append("%");
                            mOperation = false;
                            break;
                    }
                }
            }
        };
        for (int id : operationalButton) {
            findViewById(id).setOnClickListener(listener);
        }
    }
    private void setEqual(){
        findViewById(R.id.buttonEqual).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                switch (flag){
                    case 0:
                        break;
                    case 1:
                        result = num1 + num2;
                        mEqual = false;
                        break;
                    case 2:
                        result = num1 - num2;
                        mEqual = false;
                        break;
                    case 3:
                        result = num1 * num2;
                        mEqual = false;
                        break;
                    case 4:
                        result = num1 / num2;
                        mEqual = false;
                        break;
                    default:
                        break;
                }
                mOperation = true;
                mEditText.setText("" + result);
            }
        });


        Button saveData = (Button) findViewById(R.id.btn_save);
        saveData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = myDBHelper.getWritableDatabase();
                Toast.makeText(mContext,"succeed ", Toast.LENGTH_SHORT).show();
                ContentValues values = new ContentValues();
                values.put("result", result);
                db.insert("Data", null, values);
                values.clear();
            }
        });

    }
    private void setClear(){
        findViewById(R.id.buttonClear).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num1 = 0;
                num2 = 0;
                mEqual = true;
                mOperation = true;
                num = true;
                result = 0;
                mEditText.setText("");
            }
        });
    }

    public void exception(){
        try{
            if (result > Float.MAX_VALUE && result < Float.MIN_VALUE) {
                throw new Exception();
            }
            if ( flag == 4 && num2 == 0){
                throw new Exception();
            }
        }catch (Exception e){
            e.printStackTrace();
            setClear();
        }
    }

}

