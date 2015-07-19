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
import android.widget.Button;
import android.widget.TextView;

public class Calculator extends AppCompatActivity {

    private static final String TAG = "HelloJni";
    private TextView result;
    private Button b1,b2,b3,b4,b5,b6,b7,b8,b9,plus,div,mult,equals,cancel;
    private int num1 = -1, num2 = -1;
    private String operator = null;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_main);

        result = (TextView) this.findViewById(R.id.resultTextView);
        b1 = (Button) this.findViewById(R.id.button);
        b2 = (Button) this.findViewById(R.id.button2);
        b3 = (Button) this.findViewById(R.id.button3);
        b4 = (Button) this.findViewById(R.id.button4);
        b5 = (Button) this.findViewById(R.id.button5);
        b6 = (Button) this.findViewById(R.id.button6);
        b7 = (Button) this.findViewById(R.id.button7);
        b8 = (Button) this.findViewById(R.id.button8);
        b9 = (Button) this.findViewById(R.id.button9);
        plus = (Button) this.findViewById(R.id.button10);
        mult = (Button) this.findViewById(R.id.button11);
        div = (Button) this.findViewById(R.id.button12);
        equals = (Button) this.findViewById(R.id.button13);
        cancel = (Button) this.findViewById(R.id.button14);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(num1==-1) {
                    num1 = 1;
                } else {
                    if(num2==-1) {
                        num2 = 1;
                    } else {
                        num1 = 1;
                        num2 = -1;
                    }
                }
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(num1==-1) {
                    num1 = 2;
                } else {
                    if(num2==-1) {
                        num2 = 2;
                    } else {
                        num1 = 2;
                        num2 = -1;
                    }
                }
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(num1==-1) {
                    num1 = 3;
                } else {
                    if(num2==-1) {
                        num2 = 3;
                    } else {
                        num1 = 3;
                        num2 = -1;
                    }
                }
            }
        });

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(num1==-1) {
                    num1 = 4;
                } else {
                    if(num2==-1) {
                        num2 = 4;
                    } else {
                        num1 = 4;
                        num2 = -1;
                    }
                }
            }
        });

        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(num1==-1) {
                    num1 = 5;
                } else {
                    if(num2==-1) {
                        num2 = 5;
                    } else {
                        num1 = 5;
                        num2 = -1;
                    }
                }
            }
        });

        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(num1==-1) {
                    num1 = 6;
                } else {
                    if(num2==-1) {
                        num2 = 6;
                    } else {
                        num1 = 6;
                        num2 = -1;
                    }
                }
            }
        });

        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(num1==-1) {
                    num1 = 7;
                } else {
                    if(num2==-1) {
                        num2 = 7;
                    } else {
                        num1 = 7;
                        num2 = -1;
                    }
                }
            }
        });

        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(num1==-1) {
                    num1 = 8;
                } else {
                    if(num2==-1) {
                        num2 = 8;
                    } else {
                        num1 = 8;
                        num2 = -1;
                    }
                }
            }
        });

        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(num1==-1) {
                    num1 = 9;
                } else {
                    if(num2==-1) {
                        num2 = 9;
                    } else {
                        num1 = 9;
                        num2 = -1;
                    }
                }
            }
        });

        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operator = "+";
            }
        });
        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operator = "/";
            }
        });
        mult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operator = "*";
            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num1 = -1;
                num2 = -1;
                operator = null;
                result.setText("");
            }
        });
        equals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(operator!=null) {
                    switch(operator) {
                        case "+":
                            result.setText("" + sum(num1, num2));
                            break;
                        case "*":
                            result.setText("" + mult(num1, num2));
                            break;
                        case "/":
                            result.setText(""+div(num1, num2));
                            break;
                    }
                    operator=null;
                }
            }
        });
    }



    public native int sum(int a, int b);
    public native int mult(int a, int b);
    public native int div(int a, int b);

    /*
     * This is used to load the library on application
     * startup.
     */
    static {
        System.loadLibrary("calculator");
    }
}
