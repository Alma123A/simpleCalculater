package com.example.simplecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    TextView tvShow;
    double num = 0;
    double saveNum = 0;
    double total = 0;
    String message = "";
    String operator = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        tvShow = (TextView) findViewById(R.id.tvShow);
    }

    public void onClick(View v) {
        Button btn = (Button) v;
        if (R.id.btnPlus == v.getId()) {
            message += "+";
            tvShow.setText(message);
            saveNum = num;
            num = 0;
            operator = "+";
        } else if (v.getId() == R.id.btnMinus) {
            message += "-";
            tvShow.setText(message);
            saveNum = num;
            num = 0;
            operator = "-";
        } else if (v.getId() != R.id.btnMul) {
            if (R.id.btnDiv == v.getId()) {
                message += "/";
                tvShow.setText(message);
                saveNum = num;
                num = 0;
                operator = "/";
            } else if (v.getId() == R.id.btnClean) {
                message = "";
                tvShow.setText(message);
                saveNum = 0;
                num = 0;
            } else {
                num = (num * 10) + Double.parseDouble(btn.getText().toString());
                message += btn.getText().toString();
                tvShow.setText(message);
            }
        } else {
            message += "*";
            tvShow.setText(message);
            saveNum = num;
            num = 0;
            operator = "*";
        }
    }

    public void resultClick(View v) {
        double total = 0;
        if (operator.equals("+")) {
            total = saveNum + num;
        }

        if (operator.equals("-")) {
            total = saveNum - num;
        }
        if (operator.equals("/")) {
            total = saveNum / num;
        }
        if (operator.equals("*")) {
            total = saveNum * num;
        }
        if ((total * 10) % 10 == 0) {
            tvShow.setText(message + " = " + total);
        } else {
            DecimalFormat decimalFormat = new DecimalFormat("0.000");
            tvShow.setText(message + "=" + decimalFormat.format(total) + "...");
        }
    }
}
 