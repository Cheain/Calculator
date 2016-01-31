package com.calculator.hchhc.calculator;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    //声明普通数字按钮、计算符按钮，显示框R
    Button button0, button1, button2, button3, button4, button5, button6, button7, button8,
            button9, buttonPoint, buttonClear, buttonDel, buttonAdd, buttonMinus, buttonMultiply,
            buttonDivide, buttonEqual;
    Button buttonChange;
    EditText editText;
    boolean clear = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //初始化普通数字按钮、计算符按钮，显示框
        button0 = (Button) findViewById(R.id.button0);
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        button5 = (Button) findViewById(R.id.button5);
        button6 = (Button) findViewById(R.id.button6);
        button7 = (Button) findViewById(R.id.button7);
        button8 = (Button) findViewById(R.id.button8);
        button9 = (Button) findViewById(R.id.button9);
        buttonPoint = (Button) findViewById(R.id.buttonPoint);
        buttonClear = (Button) findViewById(R.id.buttonClear);
        buttonDel = (Button) findViewById(R.id.buttonDel);
        buttonAdd = (Button) findViewById(R.id.buttonAdd);
        buttonMinus = (Button) findViewById(R.id.buttonMinus);
        buttonMultiply = (Button) findViewById(R.id.buttonMultiply);
        buttonDivide = (Button) findViewById(R.id.buttonDivide);
        buttonEqual = (Button) findViewById(R.id.buttonEqual);
        buttonChange = (Button) findViewById(R.id.buttonChange);
        editText = (EditText) findViewById(R.id.editText);
        //设置普通数字按钮、计算符按钮监听器
        button0.setOnClickListener(this);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);
        button7.setOnClickListener(this);
        button8.setOnClickListener(this);
        button9.setOnClickListener(this);
        buttonPoint.setOnClickListener(this);
        buttonClear.setOnClickListener(this);
        buttonDel.setOnClickListener(this);
        buttonAdd.setOnClickListener(this);
        buttonMinus.setOnClickListener(this);
        buttonMultiply.setOnClickListener(this);
        buttonDivide.setOnClickListener(this);
        buttonEqual.setOnClickListener(this);
        //设置切换科学计算器按钮的监听器
        buttonChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳转至科学计算器的activity
                Intent intent = new Intent(MainActivity.this, ScientificActivity.class);
                //startActivity(intent);
                startActivityForResult(intent, 1);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == 2) {
            String str = data.getStringExtra("data");
        }
    }

    @Override
    public void onClick(View v) {
        String str = editText.getText().toString();
        switch (v.getId()) {
            case R.id.button0:
            case R.id.button1:
            case R.id.button2:
            case R.id.button3:
            case R.id.button4:
            case R.id.button5:
            case R.id.button6:
            case R.id.button7:
            case R.id.button8:
            case R.id.button9:
            case R.id.buttonPoint:
                //数字按钮和小数点按钮直接加在已有的字符串后面、判断是否清屏
                if (clear) {
                    clear = false;
                    editText.setText(((Button) v).getText());
                } else {
                    editText.setText(str + ((Button) v).getText());
                }
                break;
            case R.id.buttonClear:
                //清屏
                clear = false;
                editText.setText("");
                break;
            case R.id.buttonDel:
                //删除一个字符
                if (!str.equals("")) {
                    editText.setText(str.substring(0, str.length() - 1));
                }
                break;
            case R.id.buttonAdd:
            case R.id.buttonMinus:
            case R.id.buttonMultiply:
            case R.id.buttonDivide:
                //添加运算符
                clear = false;
                editText.setText(str + " " + ((Button) v).getText() + " ");
                break;
            case R.id.buttonEqual:
                //计算，并且把清屏标志置true
                clear = true;
                Boolean temp = Calculate.getResult(editText, this);
                if (temp != null) {
                    clear = temp;
                }
                break;
        }
    }
}
