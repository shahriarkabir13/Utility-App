package com.example.utilityapp;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public class ConverterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_converter);

        EditText etValue = findViewById(R.id.etValue);
        Spinner spinner = findViewById(R.id.spinnerType);
        Button btnConvert = findViewById(R.id.btnConvert);
        TextView tvResult = findViewById(R.id.tvResult);

        String[] options = {
                getString(R.string.conv_km_to_miles), getString(R.string.conv_miles_to_km),
                getString(R.string.conv_c_to_f), getString(R.string.conv_f_to_c),
                getString(R.string.conv_kg_to_lbs), getString(R.string.conv_lbs_to_kg)
        };
        spinner.setAdapter(new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_dropdown_item, options));

        btnConvert.setOnClickListener(v -> {
            try {
                double val = Double.parseDouble(etValue.getText().toString());
                double r;

                switch (spinner.getSelectedItemPosition()) {
                    case 0: r = val * 0.621371; break;
                    case 1: r = val / 0.621371; break;
                    case 2: r = val * 9 / 5 + 32; break;
                    case 3: r = (val - 32) * 5 / 9; break;
                    case 4: r = val * 2.20462; break;
                    default: r = val / 2.20462; break;
                }
                tvResult.setText(String.format(Locale.US, getString(R.string.converter_result_format), r));
            } catch (NumberFormatException e) {
                Toast.makeText(this, getString(R.string.error_valid_number), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
