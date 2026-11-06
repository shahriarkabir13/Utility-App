package com.example.utilityapp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public class BmiActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);

        EditText etHeight = findViewById(R.id.etHeight);
        EditText etWeight = findViewById(R.id.etWeight);
        Button btnBmi = findViewById(R.id.btnBmi);
        TextView tvBmi = findViewById(R.id.tvBmi);
        TextView tvCategory = findViewById(R.id.tvCategory);

        btnBmi.setOnClickListener(v -> {
            try {
                double heightCm = Double.parseDouble(etHeight.getText().toString());
                double weightKg = Double.parseDouble(etWeight.getText().toString());

                if (heightCm <= 0 || weightKg <= 0) {
                    Toast.makeText(this, getString(R.string.error_positive_values), Toast.LENGTH_SHORT).show();
                    return;
                }

                double heightM = heightCm / 100;
                double bmi = weightKg / (heightM * heightM);

                String category;
                if (bmi < 18.5) category = getString(R.string.bmi_underweight);
                else if (bmi < 25) category = getString(R.string.bmi_normal);
                else if (bmi < 30) category = getString(R.string.bmi_overweight);
                else category = getString(R.string.bmi_obese);

                tvBmi.setText(String.format(Locale.US, getString(R.string.bmi_result_format), bmi));
                tvCategory.setText(category);
            } catch (NumberFormatException e) {
                Toast.makeText(this, getString(R.string.error_enter_bmi_values), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
