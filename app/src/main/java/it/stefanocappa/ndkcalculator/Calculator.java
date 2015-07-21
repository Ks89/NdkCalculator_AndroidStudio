/*
 * Copyright (C) 2015 Stefano Cappa
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package it.stefanocappa.ndkcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Calculator extends AppCompatActivity {

    @Bind(R.id.resultTextView) public TextView result;

    private double num1 = 0, num2 = 0;
    private int mult1 = 1, mult2 = 1;
    private String operator = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_main);

        //Bind ButterKnife to be able to use annotations like @OnClick
        ButterKnife.bind(this);
    }

    @OnClick(R.id.button1) public void onNum1Clicked(View view) {
        calculateButtonPressed(1);
    }
    @OnClick(R.id.button2) public void onNum2Clicked(View view) {
        calculateButtonPressed(2);
    }
    @OnClick(R.id.button3) public void onNum3Clicked(View view) {
        calculateButtonPressed(3);
    }
    @OnClick(R.id.button4) public void onNum4Clicked(View view) {
        calculateButtonPressed(4);
    }
    @OnClick(R.id.button5) public void onNum5Clicked(View view) {
        calculateButtonPressed(5);
    }
    @OnClick(R.id.button6) public void onNum6Clicked(View view) {
        calculateButtonPressed(6);
    }
    @OnClick(R.id.button7) public void onNum7Clicked(View view) {
        calculateButtonPressed(7);
    }
    @OnClick(R.id.button8) public void onNum8Clicked(View view) {
        calculateButtonPressed(8);
    }
    @OnClick(R.id.button9) public void onNum9Clicked(View view) {
        calculateButtonPressed(9);
    }
    @OnClick(R.id.plusButton) public void onPlusClicked(View view) {
        operator = "+";
    }
    @OnClick(R.id.multButton) public void onMultClicked(View view) {
        operator = "*";
    }
    @OnClick(R.id.divButton) public void onDivClicked(View view) {
        operator = "/";
    }
    @OnClick(R.id.cancelButton) public void onCancelClicked(View view) {
        num1 = 0;
        num2 = 0;
        operator = null;
        mult1 = 1;
        mult2 = 1;
        result.setText("");
    }
    @OnClick(R.id.equalsButton) public void onEqualsClicked(View view) {
        if (operator != null) {
            switch (operator) {
                case "+":
                    result.setText("" + sum(num1, num2));
                    break;
                case "*":
                    result.setText("" + mult(num1, num2));
                    break;
                case "/":
                    result.setText("" + div(num1, num2));
                    break;
            }
            operator = null;
        }
    }



    /**
     * Method to support number higher than 9 :)
     * @param numPressed: the int number that represents the calculator's button.
     */
    private void calculateButtonPressed(int numPressed) {
        if(operator == null ) {
            num1 = numPressed + (num1 * mult1);
            mult1 = 10;
            result.setText(num1 + "");
        } else {
            num2 = numPressed + (num2 * mult2);
            mult2 = 10;
            result.setText(num2 + "");
        }
    }

    public native double sum(double a, double b);

    public native double mult(double a, double b);

    public native double div(double a, double b);

    /*
     * This is used to load the library on application
     * startup.
     */
    static {
        System.loadLibrary("calculator");
    }
}
