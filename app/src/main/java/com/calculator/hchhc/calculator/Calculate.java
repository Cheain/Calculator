package com.calculator.hchhc.calculator;

import android.content.Context;
import android.widget.EditText;

/**
 * Created by hchhc on 2016/1/31.
 */
public class Calculate {
    public static Boolean getResult(EditText editText, Context context) {
        Boolean clear = true;
        String str = editText.getText().toString();
        //没有任何字符
        if (str.equals("")) {
            return null;
        }
        //不含运算符
        if (!str.contains(" ")) {
            return null;
        }
//        String num1 = str.substring(0, str.indexOf(" "));
//        String op = str.substring(str.indexOf(" ") + 1, str.indexOf(" ") + 2);
//        String num2 = str.substring(str.indexOf(" ") + 3);

        //截取出第一二个计算因子和运算符（与另一种方式有差别，否则不能取"sin("等多字符的运算符）
        String[] s = str.split(" ");
        String num1 = "", num2 = "", op = "";
        if (s.length == 3) {
            num1 = s[0];
            op = s[1];
            num2 = s[2];
        } else if (s.length == 2) {
            num1 = s[0];
            op = s[1];
        }
        //声明并初始化结果和是否运算成功
        double result = 0;
        boolean ifResult = false;
        if (!num1.equals("") && !num2.equals("")) {
            //两个运算因子都不为空
            switch (op) {
                case "＋":
                    result = add(num1, num2);
                    ifResult = true;
                    break;
                case "－":
                    result = Minus(num1, num2);
                    ifResult = true;
                    break;
                case "×":
                    result = multiply(num1, num2);
                    ifResult = true;
                    break;
                case "÷":
                    //除数不能为0
                    if (!num2.equals("0")) {
                        result = divide(num1, num2);
                        ifResult = true;
                    } else {
                        editText.setText("别闹=。=");
                    }
                    break;
                case "√":
                    result = SQR(num1, num2);
                    ifResult = true;
                    break;
                case "^":
                    result = power(num1, num2);
                    ifResult = true;
                    break;
                case "!":
                    result = factorial(num1, num2);
                    ifResult = true;
                    break;
                case "sin(":
                    result = sin(num1, num2);
                    ifResult = true;
                    break;
                case "cos(":
                    result = cos(num1, num2);
                    ifResult = true;
                    break;
                case "tan(":
                    result = tan(num1, num2);
                    ifResult = true;
                    break;
                case "ln(":
                    result = napierianLogarithm(num1, num2);
                    ifResult = true;
                    break;
                case "log(":
                    result = tenLogarithm(num1, num2);
                    ifResult = true;
                    break;
            }
        } else if (num1.equals("") && !num2.equals("")) {
            //前空后不空，第一个运算因子视情况默认为0或1
            switch (op) {
                case "＋":
                    result = add("0", num2);
                    ifResult = true;
                    break;
                case "－":
                    result = Minus("0", num2);
                    ifResult = true;
                    break;
                case "×":
                    result = multiply("0", num2);
                    ifResult = true;
                    break;
                case "÷":
                    //除数不能为0
                    if (!num2.equals("0")) {
                        result = divide("0", num2);
                        ifResult = true;
                    } else {
                        editText.setText("别闹=。=");
                    }
                    break;
                case "√":
                    result = SQR("1", num2);
                    ifResult = true;
                    break;
                case "^":
                    result = power("1", num2);
                    ifResult = true;
                    break;
                case "!":
                    result = factorial("1", num2);
                    ifResult = true;
                    break;
                case "sin(":
                    result = sin("1", num2);
                    ifResult = true;
                    break;
                case "cos(":
                    result = cos("1", num2);
                    ifResult = true;
                    break;
                case "tan(":
                    result = tan("1", num2);
                    ifResult = true;
                    break;
                case "ln(":
                    result = napierianLogarithm("1", num2);
                    ifResult = true;
                    break;
                case "log(":
                    result = tenLogarithm("1", num2);
                    ifResult = true;
                    break;
            }
        } else if (!num1.equals("") && num2.equals("")) {
            //前不空后空，阶乘运算符可以运算，其他运算符视为没写完、不做反应
            switch (op) {
                case "＋":
                case "－":
                case "×":
                case "÷":
                case "√":
                case "^":
                case "sin(":
                case "cos(":
                case "tan(":
                case "ln(":
                case "log(":
                    editText.setText(str);
                    clear = false;
                    break;
                case "!":
                    result = factorial(num1, "1");
                    ifResult = true;
                    break;
            }
        } else {
            //前后都空，视为没写完，不做反应
            editText.setText(str);
            clear = false;
        }
        //如果运算成功，判断结果为整数还是小数并输出
        if (ifResult) {
            if (result == (int) result) {
                editText.setText((int) result + "");
            } else {
                editText.setText(result + "");
            }
            EasterEgg.easterEgg(result, context);
        }
        return clear;
    }

    //与普通运算的函数有区别，有返回值，用于后面判断结果的整数或者小数，简化代码
    private static double add(String num1, String num2) {
        return (Double.parseDouble(num1) + Double.parseDouble(num2));
    }

    private static double Minus(String num1, String num2) {
        return (Double.parseDouble(num1) - Double.parseDouble(num2));
    }

    private static double multiply(String num1, String num2) {
        return (Double.parseDouble(num1) * Double.parseDouble(num2));
    }

    private static double divide(String num1, String num2) {
        return (Double.parseDouble(num1) / Double.parseDouble(num2));
    }

    private static double SQR(String num1, String num2) {
        //开根号
        return (Double.parseDouble(num1) * Math.sqrt(Double.parseDouble(num2)));
    }

    private static double power(String num1, String num2) {
        //次方
        return (Math.pow(Double.parseDouble(num1), Double.parseDouble(num2)));
    }

    private static double factorial(String s1, String num2) {
        //阶乘
        int temp = Integer.parseInt(s1), num1 = 1;
        for (int i = 1; i <= temp; i++) {
            num1 *= i;
        }
        return (num1 * (Double.parseDouble(num2)));
    }

    private static double sin(String num1, String num2) {
        return (Double.parseDouble(num1) * Math.sin(Double.parseDouble(num2)));
    }

    private static double cos(String num1, String num2) {
        return (Double.parseDouble(num1) * Math.cos(Double.parseDouble(num2)));
    }

    private static double tan(String num1, String num2) {
        return (Double.parseDouble(num1) * Math.tan(Double.parseDouble(num2)));
    }

    private static double napierianLogarithm(String num1, String num2) {
        //e为底的对数
        return (Double.parseDouble(num1) * Math.log(Double.parseDouble(num2)));
    }

    private static double tenLogarithm(String num1, String num2) {
        //10为底的对数
        return (Double.parseDouble(num1) * (Math.log(Double.parseDouble(num2)) / Math.log(10)));
    }
}
