package com.example.mk.mycalculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();
    Button number1;
    Button number2;
    Button number3;
    Button number4;
    Button number5;
    Button number6;
    Button number7;
    Button number8;
    Button number9;
    Button number0;
    Button divide;
    Button multiply;
    Button add;
    Button subtract;
    Button initialize;
    Button calculate;
    EditText showResult;
    TextView middle;
    double operand1;
    double operand2;
    int count;
    boolean numberTurn = true;
    boolean decimalTurn = true;
    boolean buttonTurn = true;
    boolean newNumberTurn = false;
    String operator;
    String result="0";
    String[] resultSplit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        number1 = (Button)findViewById(R.id.number1);
        number2 = (Button)findViewById(R.id.number2);
        number3 = (Button)findViewById(R.id.number3);
        number4 = (Button)findViewById(R.id.number4);
        number5 = (Button)findViewById(R.id.number5);
        number6 = (Button)findViewById(R.id.number6);
        number7 = (Button)findViewById(R.id.number7);
        number8 = (Button)findViewById(R.id.number8);
        number9 = (Button)findViewById(R.id.number9);
        number0 = (Button)findViewById(R.id.number0);
        divide = (Button)findViewById(R.id.divide);
        multiply = (Button)findViewById(R.id.multiply);
        add = (Button)findViewById(R.id.add);
        subtract = (Button)findViewById(R.id.subtract);
        initialize = (Button)findViewById(R.id.initialize);
        calculate = (Button)findViewById(R.id.calculate);
        showResult = (EditText)findViewById(R.id.showResult);
        middle = (TextView)findViewById(R.id.middle);
    }

    // 각각의 버튼이 눌리면 우선 showReuslt로 올라간다..!
    public void number1Clicked(View view){
        cal(1);
    }
    public void number2Clicked(View view){
        cal(2);
    }
    public void number3Clicked(View view){
        cal(3);
    }
    public void number4Clicked(View view){
        cal(4);
    }
    public void number5Clicked(View view){
        cal(5);
    }
    public void number6Clicked(View view){
        cal(6);
    }
    public void number7Clicked(View view){
        cal(7);
    }
    public void number8Clicked(View view){
        cal(8);
    }
    public void number9Clicked(View view){
        cal(9);
    }
    public void number0Clicked(View view){
        cal(0);
    }

    public void cal(int number){

        // 눌리면 밑에만 뜨게 해준다.
        // 눌린 숫자 받아온다.
        String numberString = String.valueOf(number);

        if(numberTurn == true){
            if(showResult.getText().toString().equals("0")){
                showResult.setText(numberString);
                newNumberTurn = false;
            }else{
                if(newNumberTurn == true){
                    showResult.setText(numberString);
                    newNumberTurn = false;
                }else{
                    showResult.append(numberString);
                }
            }
            buttonTurn = true;
            decimalTurn = true;
        }


    }
    public void decimalClicked(View view){
        if(newNumberTurn == false){
            if(decimalTurn== true){
                showResult.append(".");
                decimalTurn = false;
            }
        }
        numberTurn = true;
    }
    public void initializeClicked(View view){
        middle.setText("");
        showResult.setText("0");
        operand1 = 0;
        operand2 = 0;
        numberTurn = true;
    }

    public void addClicked(View view){

        if(buttonTurn == true){
            newNumberTurn = true;
            numberTurn = true;
            decimalTurn = true;
            count = count +1;
            if(count == 3){
                count = 2;
            }

            if(count == 1){
                operand1 = Double.parseDouble(showResult.getText().toString());
                middle.append(String.valueOf(operand1));
                middle.append("+");
                operator = "+";
            }else if(count == 2){
                operand2 = Double.parseDouble(showResult.getText().toString());
                if(operator.equals("+")){
                    operand1 = operand1 + operand2;
                }else if(operator.equals("-")){
                    operand1 = operand1 - operand2;
                }else if(operator.equals("*")){
                    operand1 = operand1 * operand2;
                }else if(operator.equals("/")){
                    operand1 = operand1 / operand2;
                }
                operator = "+";
                showResult.setText(String.valueOf(operand1));
                middle.append(String.valueOf(operand2));
                middle.append("+");
            }
            buttonTurn = false;
        }else{
            return;
        }


    }

    public void subtractClicked(View view){
        newNumberTurn = true;
        if(buttonTurn == true){
            decimalTurn = true;
            numberTurn = true;
            count = count +1;
            if(count == 3){
                count = 2;
            }

            if(count == 1){
                operand1 = Double.parseDouble(showResult.getText().toString());
                middle.append(String.valueOf(operand1));
                middle.append("-");
                operator = "-";
            }else if(count == 2){
                operand2 = Double.parseDouble(showResult.getText().toString());
                if(operator.equals("+")){
                    operand1 = operand1 + operand2;
                }else if(operator.equals("-")){
                    operand1 = operand1 - operand2;
                }else if(operator.equals("*")){
                    operand1 = operand1 * operand2;
                }else if(operator.equals("/")){
                    operand1 = operand1 / operand2;
                }
                operator = "-";
                showResult.setText(String.valueOf(operand1));
                middle.append(String.valueOf(operand2));
                middle.append("-");
            }
            buttonTurn = false;
        }else{
            return;
        }


    }

    public void multiplyClicked(View view){
        newNumberTurn = true;
        if(buttonTurn == true){
            decimalTurn = true;
            numberTurn = true;
            count = count +1;
            if(count == 3){
                count = 2;
            }

            if(count == 1){
                operand1 = Double.parseDouble(showResult.getText().toString());
                middle.append(String.valueOf(operand1));
                middle.append("*");
                operator = "*";
            }else if(count == 2){
                operand2 = Double.parseDouble(showResult.getText().toString());
                if(operator.equals("+")){
                    operand1 = operand1 + operand2;
                }else if(operator.equals("-")){
                    operand1 = operand1 - operand2;
                }else if(operator.equals("*")){
                    operand1 = operand1 * operand2;
                }else if(operator.equals("/")){
                    operand1 = operand1 / operand2;
                }
                operator = "*";
                showResult.setText(String.valueOf(operand1));
                middle.append(String.valueOf(operand2));
                middle.append("*");
            }
            buttonTurn = false;
        }else{
            return;
        }


    }
    public void divideClicked(View view){
        newNumberTurn = true;
        if(buttonTurn == true){
            decimalTurn = true;
            numberTurn = true;
            count = count +1;
            if(count == 3){
                count = 2;
            }

            if(count == 1){
                operand1 = Double.parseDouble(showResult.getText().toString());
                middle.append(String.valueOf(operand1));
                middle.append("/");
                operator = "/";
            }else if(count == 2){
                operand2 = Double.parseDouble(showResult.getText().toString());
                if(operator.equals("+")){
                    operand1 = operand1 + operand2;
                }else if(operator.equals("-")){
                    operand1 = operand1 - operand2;
                }else if(operator.equals("*")){
                    operand1 = operand1 * operand2;
                }else if(operator.equals("/")){
                    operand1 = operand1 / operand2;
                }
                operator = "/";
                showResult.setText(String.valueOf(operand1));
                middle.append(String.valueOf(operand2));
                middle.append("/");
            }
            buttonTurn = false;
        }else{
            return;
        }


    }

    public void calculateClicked(View view){
        if(operator.equals("")){
            return;
        }
        operand2 = Double.parseDouble(showResult.getText().toString());
        if(operator.equals("+")){
            operand1 = operand1 + operand2;
        }else if(operator.equals("-")){
            operand1 = operand1 - operand2;
        }else if(operator.equals("*")){
            operand1 = operand1 * operand2;
        }else if(operator.equals("/")){
            operand1 = operand1 / operand2;
        }
        showResult.setText(String.valueOf(operand1));
        middle.setText("");
        count = 0;
        operator="";
        numberTurn = false;
    }
}
