package com.example.calculator2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.example.calculator2.R;

public class MainActivity extends AppCompatActivity {

    EditText t1, t2, t3;
    Button b1, b2, b3, b4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t1 = (EditText) findViewById(R.id.editTextText);
        t2 = (EditText) findViewById(R.id.editTextText2);
        t3 = (EditText) findViewById(R.id.editTextText3);
        b1 = (Button) findViewById(R.id.button);
        b2 = (Button) findViewById(R.id.button2);
        b3 = (Button) findViewById(R.id.button3);
        b4 = (Button) findViewById(R.id.button4);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int n1 = Integer.parseInt(t1.getText().toString());
                int n2 = Integer.parseInt(t2.getText().toString());
                int n3 = n1 + n2;
                String n4 = String.valueOf(n3);
                t3.setText(n4);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int n1 = Integer.parseInt(t1.getText().toString());
                int n2 = Integer.parseInt(t2.getText().toString());
                int n3 = n1 - n2;
                String n4 = String.valueOf(n3);
                t3.setText(n4);
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int n1 = Integer.parseInt(t1.getText().toString());
                int n2 = Integer.parseInt(t2.getText().toString());
                int n3 = n1 * n2;
                String n4 = String.valueOf(n3);
                t3.setText(n4);
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int n1 = Integer.parseInt(t1.getText().toString());
                int n2 = Integer.parseInt(t2.getText().toString());
                int n3 = n1 / n2;
                String n4 = String.valueOf(n3);
                t3.setText(n4);
            }
        });
    }
}
