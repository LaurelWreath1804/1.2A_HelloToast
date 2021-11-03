package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import calculator.R;

public class MainActivity extends AppCompatActivity {

    private EditText display1, display2;
    boolean operatorButtonCLicked = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        display1 = findViewById(R.id.editText1);
        display1.setShowSoftInputOnFocus(false);
        display1.setText("");

        display2 = findViewById(R.id.editText2);
        display2.setShowSoftInputOnFocus(false);
        display2.setText("0");

    }

    private void calculate() {
        String str1 = display1.getText().toString();
        String str2 = display2.getText().toString();

        int len1 = str1.length();
        if (len1 != 0) {
            int operand1 = Integer.parseInt(str1.substring(0, len1 - 1));
            int operand2 = Integer.parseInt(str2);
            char operator = str1.charAt(len1 - 1);

            int result = 0;
            switch (operator) {
                case '+':
                    result = operand1 + operand2;
                    break;
                case '-':
                    result = operand1 - operand2;
                    break;
                case '×':
                    result = operand1 * operand2;
                    break;
                case '÷':
                    result = operand1 / operand2;
                    break;
            }

            display2.setText(String.valueOf(result));
        }
    }

    private void updateText(String newStr) {
        if (operatorButtonCLicked) {
            display2.setText("");
        }

        String oldStr = display2.getText().toString();
        if (oldStr.equals("0")) {
            display2.setText("");
            display2.setText(newStr);
        } else {
            display2.setText(String.format("%s%s", oldStr, newStr));
        }

        operatorButtonCLicked = false;
    }

    private void updateOperator(String newStr) {
        String oldStr1 = display1.getText().toString();
        String oldStr2 = display2.getText().toString();
        int lenStr1 = oldStr1.length();

        if (lenStr1 == 0) {
            display1.setText(String.format("%s%s", oldStr2, newStr));
        } else if (!operatorButtonCLicked) {
            calculate();
            oldStr2 = display2.getText().toString();
            display1.setText(String.format("%s%s", oldStr2, newStr));
        } else {
            display1.setText(String.format("%s%s", oldStr1.substring(0, lenStr1 - 1), newStr));
        }

        operatorButtonCLicked = true;
    }

    public void zero_button(View view) {
        updateText("0");
    }

    public void one_button(View view) {
        updateText("1");
    }

    public void two_button(View view) {
        updateText("2");
    }

    public void three_button(View view) {
        updateText("3");
    }

    public void four_button(View view) {
        updateText("4");
    }

    public void five_button(View view) {
        updateText("5");
    }

    public void six_button(View view) {
        updateText("6");
    }

    public void seven_button(View view) {
        updateText("7");
    }

    public void eight_button(View view) {
        updateText("8");
    }

    public void nine_button(View view) {
        updateText("9");
    }

    public void c_button(View view) {
        display1.setText("");
        display2.setText("0");
    }

    public void ce_button(View view) {
        display2.setText("0");
    }

    public void plus_button(View view) {
        updateOperator("+");
    }

    public void subtract_button(View view) {
        updateOperator("-");
    }

    public void multiply_button(View view) {
        updateOperator("×");
    }

    public void divide_button(View view) {
        updateOperator("÷");
    }

    public void backspace_button(View view) {
        String oldStr = display2.getText().toString();
        int len = oldStr.length();
        if (len > 0)
            display2.setText(oldStr.substring(0, len - 1));
    }

    public void change_sign_button(View view) {
        String oldStr = display2.getText().toString();
        int len = oldStr.length();
        if (len > 0) {
            if (oldStr.charAt(0) == '-')
                display2.setText(oldStr.substring(1, len));
            else
                display2.setText(String.format("%s%s", "-", oldStr));
        }
    }

    public void equal_button(View view) {
        calculate();
        display1.setText("");
        operatorButtonCLicked = true;
    }
}