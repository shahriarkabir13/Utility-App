package com.example.utilityapp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public class TipActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tip);

        EditText etBill = findViewById(R.id.etBill);
        EditText etTip = findViewById(R.id.etTip);
        EditText etPeople = findViewById(R.id.etPeople);
        Button btnSplit = findViewById(R.id.btnSplit);
        TextView tvTotal = findViewById(R.id.tvTotal);
        TextView tvPerPerson = findViewById(R.id.tvPerPerson);

        btnSplit.setOnClickListener(v -> {
            try {
                double bill = Double.parseDouble(etBill.getText().toString());
                double tipPercent = Double.parseDouble(etTip.getText().toString());
                int people = Integer.parseInt(etPeople.getText().toString());

                if (people <= 0) {
                    Toast.makeText(this, getString(R.string.error_people_count), Toast.LENGTH_SHORT).show();
                    return;
                }

                double total = bill + (bill * tipPercent / 100);
                double perPerson = total / people;

                tvTotal.setText(String.format(Locale.US, getString(R.string.total_format), total));
                tvPerPerson.setText(String.format(Locale.US, getString(R.string.per_person_format), perPerson));
            } catch (NumberFormatException e) {
                Toast.makeText(this, getString(R.string.error_fill_fields), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
