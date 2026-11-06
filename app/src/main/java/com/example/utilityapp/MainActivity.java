package com.example.utilityapp;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btnCalc).setOnClickListener(v ->
                startActivity(new Intent(this, CalculatorActivity.class)));
        findViewById(R.id.btnConv).setOnClickListener(v ->
                startActivity(new Intent(this, ConverterActivity.class)));
        findViewById(R.id.btnBmi).setOnClickListener(v ->
                startActivity(new Intent(this, BmiActivity.class)));
        findViewById(R.id.btnTip).setOnClickListener(v ->
                startActivity(new Intent(this, TipActivity.class)));
    }
}
