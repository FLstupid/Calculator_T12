package com.example.calculator_t12;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import org.mariuszgromada.math.mxparser.*;

public class MainActivity extends AppCompatActivity {

    private EditText display;
    private TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        display = findViewById(R.id.input);
        result = findViewById(R.id.Result);
        display.setShowSoftInputOnFocus(false);

        display.setOnClickListener(view -> {
            if(getString(R.string.display).equals(display.getText().toString())){
                display.setText("");
            }
        });
    }

    public void updateText(String addStr){
        String oldStr = display.getText().toString();
        int cursorPos = display.getSelectionStart();
        String leftStr = oldStr.substring(0,cursorPos);
        String rightStr = oldStr.substring(cursorPos);
        if(getString(R.string.display).equals(display.getText().toString())){
            if(!(addStr.equals("/") || addStr.equals("*") || addStr.equals("+")
                    || addStr.equals("-") || addStr.equals(".") || addStr.equals("%"))) {
                display.setText(addStr);
                cursorPos = display.getSelectionStart();
                display.setSelection(cursorPos + 1);
            }
        } else {
            display.setText(String.format("%s%s%s",leftStr,addStr,rightStr));
            display.setSelection(cursorPos + 1);
        }
    }

    public void zeroBTN(View view){
        updateText("0");
    }

    public void oneBTN(View view){
        updateText("1");
    }

    public void twoBTN(View view){
        updateText("2");
    }

    public void threeBTN(View view){
        updateText("3");
    }

    public void fourBTN(View view){
        updateText("4");
    }

    public void fiveBTN(View view){
        updateText("5");
    }

    public void sixBTN(View view){
        updateText("6");
    }

    public void sevenBTN(View view){
        updateText("7");
    }

    public void eightBTN(View view){
        updateText("8");
    }

    public void nineBTN(View view){
        updateText("9");
    }

    public void plusBTN(View view){
        updateText("+");
    }

    public void minusBTN(View view){
        updateText("-");
    }

    public void divideBTN(View view){
        updateText("/");
    }

    public void multiBTN(View view){
        updateText("*");
    }

    public void dotBTN(View view){
        updateText(".");
    }

    public void percentBTN(View view){
        updateText("%");
    }

    public void equalsBTN(View view){
        String UserExp = display.getText().toString();

        Expression expression = new Expression(UserExp);

        String resultExp = String.valueOf(expression.calculate());

        result.setText(resultExp);
    }

    public void clearBTN(View view){
        display.setText("");
    }

    public void deleteBTN(View view){
        int cursorPos = display.getSelectionStart();
        int textLen = display.getText().length();

        if (cursorPos != 0 && textLen != 0) {
            SpannableStringBuilder selection = (SpannableStringBuilder) display.getText();
            selection.replace(cursorPos - 1, cursorPos, "");
            display.setText(selection);
            display.setSelection(cursorPos - 1);
        }
    }
}