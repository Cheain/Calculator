package com.calculator.hchhc.calculator;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ScientificActivity extends AppCompatActivity implements View.OnClickListener {
    //声明普通数字按钮、计算符按钮，显示框
    Button button0, button1, button2, button3, button4, button5, button6, button7, button8,
            button9, buttonPoint, buttonClear, buttonDel, buttonAdd, buttonMinus, buttonMultiply,
            buttonDivide, buttonEqual;
    //科学计算符
    Button buttonRightBracket, buttonLiftBracket, buttonPI, buttonE, buttonSQR, buttonPower,
            buttonFactorial, buttonSin, buttonCos, buttonTan, buttonNapierianLogarithm, buttonTenLogarithm;
    Button buttonChange;
    EditText editText;
    boolean clear = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scientific);
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
        //初始化科学计算符按钮
        buttonRightBracket = (Button) findViewById(R.id.buttonRightBracket);
        buttonLiftBracket = (Button) findViewById(R.id.buttonLiftBracket);
        buttonPI = (Button) findViewById(R.id.buttonPI);
        buttonE = (Button) findViewById(R.id.buttonE);
        buttonSQR = (Button) findViewById(R.id.buttonSQR);
        buttonPower = (Button) findViewById(R.id.buttonPower);
        buttonFactorial = (Button) findViewById(R.id.buttonFactorial);
        buttonSin = (Button) findViewById(R.id.buttonSin);
        buttonCos = (Button) findViewById(R.id.buttonCos);
        buttonTan = (Button) findViewById(R.id.buttonTan);
        buttonNapierianLogarithm = (Button) findViewById(R.id.buttonNapierianLogarithm);
        buttonTenLogarithm = (Button) findViewById(R.id.buttonTenLogarithm);
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
        //设置科学计算符按钮监听器
        buttonRightBracket.setOnClickListener(this);
        buttonLiftBracket.setOnClickListener(this);
        buttonPI.setOnClickListener(this);
        buttonE.setOnClickListener(this);
        buttonSQR.setOnClickListener(this);
        buttonPower.setOnClickListener(this);
        buttonFactorial.setOnClickListener(this);
        buttonSin.setOnClickListener(this);
        buttonCos.setOnClickListener(this);
        buttonTan.setOnClickListener(this);
        buttonNapierianLogarithm.setOnClickListener(this);
        buttonTenLogarithm.setOnClickListener(this);
        //设置切换普通计算器按钮的监听器
        buttonChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳转至普通计算器的activity
//                Intent intent = new Intent(ScientificActivity.this, MainActivity.class);
//                startActivity(intent);
                Intent intent = new Intent();
                intent.putExtra("data", "1");
                setResult(2, intent);
                finish();
            }
        });
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
            case R.id.buttonPI:
                if (clear) {
                    clear = false;
                    editText.setText("3.1415926535898");
                } else {
                    editText.setText(str + "3.1415926535898");
                }
                break;
            case R.id.buttonE:
                if (clear) {
                    clear = false;
                    editText.setText("2.718281828459");
                } else {
                    editText.setText(str + "2.718281828459");
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
            case R.id.buttonRightBracket:
            case R.id.buttonLiftBracket:
            case R.id.buttonSQR:
            case R.id.buttonPower:
            case R.id.buttonFactorial:
            case R.id.buttonSin:
            case R.id.buttonCos:
            case R.id.buttonTan:
            case R.id.buttonNapierianLogarithm:
            case R.id.buttonTenLogarithm:
                if (clear) {
                    //添加运算符
                    clear = false;
                    editText.setText(" " + ((Button) v).getText() + " ");
                } else {
                    editText.setText(str + " " + ((Button) v).getText() + " ");
                }
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
