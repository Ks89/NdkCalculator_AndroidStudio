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

import android.view.View;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Calculator extends AppCompatActivity {

    @Bind(R.id.resultTextView)
    public TextView resultTextView;

    // used to the number composed on the calculator.
    //this is valid for both numbers. When a number is composed will be stored in num1 or num2.
    private double temp = 0;

    //the real numbers saved and used to get the result
    private double num1 = 0, num2 = 0;

    private String operator = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_main);

        //Bind ButterKnife to be able to use annotations like @OnClick
        ButterKnife.bind(this);
    }

    //I'm using @OnClick with ButterKnife to set an Action Listener to every
    //button in a quicker and cleaner way.
    @OnClick(R.id.button1)
    public void onNum1Clicked(View view) {
        calculateButtonPressed(1);
    }

    @OnClick(R.id.button2)
    public void onNum2Clicked(View view) {
        calculateButtonPressed(2);
    }

    @OnClick(R.id.button3)
    public void onNum3Clicked(View view) {
        calculateButtonPressed(3);
    }

    @OnClick(R.id.button4)
    public void onNum4Clicked(View view) {
        calculateButtonPressed(4);
    }

    @OnClick(R.id.button5)
    public void onNum5Clicked(View view) {
        calculateButtonPressed(5);
    }

    @OnClick(R.id.button6)
    public void onNum6Clicked(View view) {
        calculateButtonPressed(6);
    }

    @OnClick(R.id.button7)
    public void onNum7Clicked(View view) {
        calculateButtonPressed(7);
    }

    @OnClick(R.id.button8)
    public void onNum8Clicked(View view) {
        calculateButtonPressed(8);
    }

    @OnClick(R.id.button9)
    public void onNum9Clicked(View view) {
        calculateButtonPressed(9);
    }

    @OnClick(R.id.plusButton)
    public void onPlusClicked(View view) {
        operator = "+";
        num1 = temp;
        temp = 0;
    }

    @OnClick(R.id.multButton)
    public void onMultClicked(View view) {
        operator = "*";
        num1 = temp;
        temp = 0;
    }

    @OnClick(R.id.divButton)
    public void onDivClicked(View view) {
        operator = "/";
        num1 = temp;
        temp = 0;
    }

    @OnClick(R.id.cancelButton)
    public void onCancelClicked(View view) {
        resetAll();
    }

    @OnClick(R.id.equalsButton)
    public void onEqualsClicked(View view) {
        num2 = temp;

        double result = 0;
        if (operator != null) {
            switch (operator) {
                case "+":
                    result = sum(num1, num2);
                    break;
                case "*":
                    result = mult(num1, num2);
                    break;
                case "/":
                    result = div(num1, num2);
                    break;
            }
            operator = null;
        }

        resultTextView.setText("" + result);
    }


    /**
     * Method to support number higher than 9 :)
     *
     * @param numPressed: the int number that represents the calculator's button.
     */
    private void calculateButtonPressed(int numPressed) {
        temp = composeNumber(temp, numPressed);

        resultTextView.setText(temp + "");
    }

    private void resetAll() {
        num1 = 0;
        num2 = 0;
        temp = 0;
        operator = null;
        resultTextView.setText("");
    }

    public native double composeNumber(double temp, int numPressed);

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
