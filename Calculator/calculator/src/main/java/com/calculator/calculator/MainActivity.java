package com.calculator.calculator;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.view.View;


public class MainActivity extends ActionBarActivity {

    Double result = 0.0, first = 0.0, second = 0.0;
    TextView res;
    char operator = '+';

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /*
    *
    *  onClick listeners to DIGITS
    *
     */

    public void onClick_1(View view) {
        result = (Double) result * 10 + 1;
        res =(TextView)findViewById(R.id.result);
        res.setText(String.valueOf(result));
    }
    public void onClick_2(View view) {
        result = result*10 + 2;
        res =(TextView)findViewById(R.id.result);
        res.setText(result.toString());
    }
    public void onClick_3(View view) {
        result = result*10 + 3;
        res =(TextView)findViewById(R.id.result);
        res.setText(result.toString());
    }
    public void onClick_4(View view) {
        result = result*10 + 4;
        res =(TextView)findViewById(R.id.result);
        res.setText(result.toString());
    }
    public void onClick_5(View view) {
        result = result*10 + 5;
        res =(TextView)findViewById(R.id.result);
        res.setText(result.toString());
    }
    public void onClick_6(View view) {
        result = result*10 + 6;
        res =(TextView)findViewById(R.id.result);
        res.setText(result.toString());
    }
    public void onClick_7(View view) {
        result = result*10 + 7;
        res =(TextView)findViewById(R.id.result);
        res.setText(result.toString());
    }
    public void onClick_8(View view) {
        result = result*10 + 8;
        res =(TextView)findViewById(R.id.result);
        res.setText(result.toString());
    }
    public void onClick_9(View view) {
        result = result*10 + 9;
        res =(TextView)findViewById(R.id.result);
        res.setText(result.toString());
    }
    public void onClick_0(View view) {
        result = result*10;
        res =(TextView)findViewById(R.id.result);
        res.setText(result.toString());
    }

    /*
    *
    *   onClick listeners to OPERATORS
    *
     */

    public void onClick_plus(View view) {
        first = result;
        result = 0.0;
        operator = '+';
        res =(TextView)findViewById(R.id.result);
        res.setText(result.toString());
    }

    public void onClick_minus(View view) {
        first = result;
        result = 0.0;
        operator = '-';
        res =(TextView)findViewById(R.id.result);
        res.setText(result.toString());
    }

    public void onClick_per(View view) {
        first = result;
        result = 0.0;
        operator = '*';
        res =(TextView)findViewById(R.id.result);
        res.setText(result.toString());
    }

    public void onClick_div(View view) {
        first = result;
        result = 0.0;
        operator = '/';
        res =(TextView)findViewById(R.id.result);
        res.setText(result.toString());
    }

    public void onClick_clear(View view) {
        first = 0.0;
        second = 0.0;
        result = 0.0;
        operator = ' ';
        res =(TextView)findViewById(R.id.result);
        res.setText(result.toString());
    }

    public void onClick_calc(View view) {
        second = result;
        switch (operator) {
            case '+':   result = first + second;
                        break;
            case '-':   result = first - second;
                        break;
            case '*':   result = first * second;
                break;
            case '/':   result = first / second;
                break;
            default:
                        break;
        }

        res =(TextView)findViewById(R.id.result);
        res.setText(result.toString());
    }
}
