package com.example.utilityapp;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class CalculatorActivity extends AppCompatActivity {

    EditText etNum1, etNum2;
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        etNum1 = findViewById(R.id.etNum1);
        etNum2 = findViewById(R.id.etNum2);
        tvResult = findViewById(R.id.tvResult);

        View.OnClickListener listener = v -> calculate(v.getId());

        findViewById(R.id.btnAdd).setOnClickListener(listener);
        findViewById(R.id.btnSub).setOnClickListener(listener);
        findViewById(R.id.btnMul).setOnClickListener(listener);
        findViewById(R.id.btnDiv).setOnClickListener(listener);
    }

    private void calculate(int id) {
        try {
            double x = Double.parseDouble(etNum1.getText().toString());
            double y = Double.parseDouble(etNum2.getText().toString());
            double result;

            if (id == R.id.btnAdd) {
                result = x + y;
            } else if (id == R.id.btnSub) {
                result = x - y;
            } else if (id == R.id.btnMul) {
                result = x * y;
            } else {
                if (y == 0) {
                    tvResult.setText(getString(R.string.error_divide_by_zero));
                    return;
                }
                result = x / y;
            }
            tvResult.setText(getString(R.string.result_format, String.valueOf(result)));
        } catch (NumberFormatException e) {
            Toast.makeText(this, getString(R.string.error_valid_numbers), Toast.LENGTH_SHORT).show();
        }
    }
}
