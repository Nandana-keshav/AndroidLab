package com.example.prgm5;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView display;
    private String input = "";
    private double firstNum = 0;
    private String operator = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        display = findViewById(R.id.display);

        int[] ids = {
                R.id.btn0, R.id.btn1, R.id.btn2, R.id.btn3,
                R.id.btn4, R.id.btn5, R.id.btn6, R.id.btn7,
                R.id.btn8, R.id.btn9, R.id.btnAdd, R.id.btnSub,
                R.id.btnMul, R.id.btnDiv, R.id.btnClear, R.id.btnEqual
        };

        for (int id : ids) {
            Button b = findViewById(id);
            b.setOnClickListener(this::handleClick);
        }
    }

    private void handleClick(View v) {
        Button b = (Button) v;
        String text = b.getText().toString();

        switch (text) {
            case "C":
                input = "";
                firstNum = 0;
                operator = "";
                display.setText("0");
                break;
            case "+":
            case "-":
            case "*":
            case "/":
                if (!input.isEmpty()) {
                    firstNum = Double.parseDouble(input);
                    operator = text;
                    input = "";
                }
                break;
            case "=":
                if (!input.isEmpty() && !operator.isEmpty()) {
                    double secondNum = Double.parseDouble(input);
                    double result = calculate(firstNum, secondNum, operator);
                    display.setText(String.valueOf(result));
                    input = String.valueOf(result);
                    operator = "";
                }
                break;
            default:
                input += text;
                display.setText(input);
        }
    }

    private double calculate(double a, double b, String op) {
        switch (op) {
            case "+": return a + b;
            case "-": return a - b;
            case "*": return a * b;
            case "/": return b != 0 ? a / b : 0;
            default: return 0;
        }
    }
}
