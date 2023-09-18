package com.example.arithmeticoperator1;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button buttonAdd, buttonSub, buttonMul, buttonDiv;
    EditText editTextN1, editTextN2;
    TextView textView;
    int num1, num2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonAdd = findViewById(R.id.button_add);
        buttonSub = findViewById(R.id.button_sub);
        buttonMul = findViewById(R.id.button_mul);
        buttonDiv = findViewById(R.id.button_div);
        editTextN1 = findViewById(R.id.number1);
        editTextN2 = findViewById(R.id.number2);
        textView = findViewById(R.id.answer);

        buttonAdd.setOnClickListener(this);
        buttonSub.setOnClickListener(this);
        buttonMul.setOnClickListener(this);
        buttonDiv.setOnClickListener(this);
    }

    public int getIntFromEditText(EditText editText) {
        String input = editText.getText().toString().trim();
        if (input.isEmpty()) {
            Toast.makeText(this, "Enter a number", Toast.LENGTH_SHORT).show();
            return 0;
        }

        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Invalid number format", Toast.LENGTH_SHORT).show();
            return 0;
        }
    }


    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View view) {
        num1 = getIntFromEditText(editTextN1);
        num2 = getIntFromEditText(editTextN2);

        if (view.getId() == R.id.button_add) {
            textView.setText("Answer = " + (num1 + num2));
        } else if (view.getId() == R.id.button_sub) {
            textView.setText("Answer = " + (num1 - num2));
        } else if (view.getId() == R.id.button_mul) {
            textView.setText("Answer = " + (num1 * num2));
        } else if (view.getId() == R.id.button_div) {
            if (num2 != 0) {
                textView.setText("Answer = " + ((float) num1 / num2));
            } else {
                textView.setText("Answer = Cannot divide by zero");
            }
        }
    }
}