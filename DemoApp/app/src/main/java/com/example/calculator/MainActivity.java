package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity {
    private TextView calcScreen,non,statusString;
    private ImageView txt0,txt1,txt2,txt3,txt4,txt5,txt6,txt7,txt8,txt9,sum,sub,multiply,divide,percentage,back,clear;
    private ImageView equal,dot;
    private String input = "";
    private double val1 = Double.NaN;
    private double val2 = Double.NaN;
    private boolean flagSum = false , flagSub = false , flagMul = false , flagDiv = false , flagPer = false;
    private double total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initWidget();
        initOnClickListener();
        registerMyReceiver();
    }
    BroadcastReceiver mBatteryReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            IntentFilter iFilter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
            Intent batteryStatus = context.registerReceiver(null, iFilter);
            int mBatteryLevel = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, -1);
            assert batteryStatus != null;
            int status = batteryStatus.getIntExtra(BatteryManager.EXTRA_PLUGGED, -1);
            String battery=" ";
            if(status==0){
                battery = Integer.toString(mBatteryLevel);
                statusString.setText("UNPLUGGED");
            }
            else{
                battery = Integer.toString(mBatteryLevel);
                battery = battery + "+";
                statusString.setText("PLUGGED IN");
            }
            Toast toast = Toast.makeText(context, "Current Battery Level: " + battery, Toast.LENGTH_LONG);
            toast.setGravity(Gravity.TOP,0,0);
            toast.show();
            non.setText(battery);
        }
    };

    private void registerMyReceiver() {
        IntentFilter mBatteryLevelFilter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
        registerReceiver(mBatteryReceiver, mBatteryLevelFilter);
    }
    private void initOnClickListener() {
        txt0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input = input + "0";
                calcScreen.setText(input);
            }
        });
        txt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input = input + "1";
                calcScreen.setText(input);
            }
        });
        txt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input = input + "2";
                calcScreen.setText(input);
            }
        });
        txt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input = input + "3";
                calcScreen.setText(input);
            }
        });
        txt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input = input + "4";
                calcScreen.setText(input);
            }
        });
        txt5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input = input + "5";
                calcScreen.setText(input);
            }
        });
        txt6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input = input + "6";
                calcScreen.setText(input);
            }
        });
        txt7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input = input + "7";
                calcScreen.setText(input);
            }
        });
        txt8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input = input + "8";
                calcScreen.setText(input);
            }
        });
        txt9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input = input + "9";
                calcScreen.setText(input);
            }
        });
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input = "";
                val1 = Double.NaN;
                val2 = Double.NaN;
                total = 0;
                calcScreen.setText("0");

            }
        });
        back.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                input = "";
                calcScreen.setText("0");
                return true;
            }
        });
        back.setOnClickListener(new View.OnClickListener() {//delete from back.. as backspace
            @Override
            public void onClick(View v) {
                if (calcScreen.getText() == "0") {
                    calcScreen.setText("0");
                }
                else {
                    String newString = calcScreen.getText().toString();
                    newString = newString.substring(0, newString.length() - 1);
                    calcScreen.setText(newString);
                    input = newString;
                }
            }
        });
        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(total==0){
                    calcScreen.setText("0");
                }
                else
                {
                    flagCheck();
                }
            }
        });
        sum.setOnClickListener(new View.OnClickListener() { //on second click on + their occur an error run time error
            @Override
            public void onClick(View v) {
                if(input.equals("")){
                    calcScreen.setText("0");
                }
                else {
                    calcScreen.setText("0");
                    flagCheck();
                    input = "";
                    flagSum = true;
                }
            }
        });
        sub.setOnClickListener(new View.OnClickListener() { //on second click on + their occur an error run time error
            @Override
            public void onClick(View v) {
                if(input.equals("")){
                    calcScreen.setText("0");
                }
                else {
                    calcScreen.setText("0");
                    flagCheck();
                    input = "";
                    flagSub = true;
                }
            }

        });
        multiply.setOnClickListener(new View.OnClickListener() { //on second click on + their occur an error run time error
            @Override
            public void onClick(View v) {
                if(input.equals("")){
                    calcScreen.setText("0");
                }
                else {
                    calcScreen.setText("0");
                    flagCheck();
                    input = "";
                    flagMul = true;
                }
            }

        });
        divide.setOnClickListener(new View.OnClickListener() { //on second click on + their occur an error run time error
            @Override
            public void onClick(View v) {
                if(input.equals("")){
                    calcScreen.setText("0");
                }
                else {
                    calcScreen.setText("0");
                    flagCheck();
                    input = "";
                    flagDiv = true;
                }
            }
        });
        dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input = input + ".";
                calcScreen.setText(input);
            }
        });
        percentage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(input.equals("")){
                    calcScreen.setText("0");
                }
                else {
                    calcScreen.setText("0");
                    flagCheck();
                    input = "";
                    flagPer = true;
                }
            }
        });
    }

    public void initWidget(){
        calcScreen = (TextView) findViewById(R.id.calcScreen);
        non = (TextView) findViewById(R.id.non);
        statusString = (TextView) findViewById(R.id.statusString);
        txt0 = (ImageView) findViewById(R.id.txt0);
        txt1 = (ImageView) findViewById(R.id.txt1);
        txt2 = (ImageView) findViewById(R.id.txt2);
        txt3 = (ImageView) findViewById(R.id.txt3);
        txt4 = (ImageView) findViewById(R.id.txt4);
        txt5 = (ImageView) findViewById(R.id.txt5);
        txt6 = (ImageView) findViewById(R.id.txt6);
        txt7 = (ImageView) findViewById(R.id.txt7);
        txt8 = (ImageView) findViewById(R.id.txt8);
        txt9 = (ImageView) findViewById(R.id.txt9);
        clear = (ImageView) findViewById(R.id.clear);
        back = (ImageView) findViewById(R.id.backspace);
        equal = (ImageView) findViewById(R.id.equals);
        sum = (ImageView) findViewById(R.id.sum);
        sub = (ImageView) findViewById(R.id.subs);
        multiply = (ImageView) findViewById(R.id.multiply);
        divide = (ImageView) findViewById(R.id.divide);
        dot = (ImageView) findViewById(R.id.dot);
        percentage = (ImageView) findViewById(R.id.percent);

    }
    public void flagCheck(){
        /*if(input.equals("")){
            calcScreen.setText("NaN");
        }
        else*/
        if(!Double.isNaN(val1)) {
            val2 = Double.parseDouble(input);
            if(flagSum){
                total = total + val2;
                int newNumber = (int) total;
                if(newNumber>total||newNumber<total){
                    String tot = Double.toString(total);
                    calcScreen.setText(tot);
                    val1=total;
                    val2=Double.NaN;
                    flagSum = false;
                }
                else
                {
                    String tot = Integer.toString(newNumber);
                    calcScreen.setText(tot);
                    val1=newNumber;
                    val2=Double.NaN;
                    flagSum = false;
                }
                /*String tot = Integer.toString((int)total);
                calcScreen.setText(tot);
                val1=total;
                val2=Double.NaN;
                flagSum =false;*/
            }
            else if (flagSub){
                total = total - val2;
                int newNumber = (int) total;
                if(newNumber>total||newNumber<total){
                    String tot = Double.toString(total);
                    calcScreen.setText(tot);
                    val1=total;
                    val2=Double.NaN;
                    flagSub = false;
                }
                else
                {
                    String tot = Integer.toString(newNumber);
                    calcScreen.setText(tot);
                    val1=newNumber;
                    val2=Double.NaN;
                    flagSub = false;
                }
                /*String tot = Integer.toString((int)total);
                calcScreen.setText(tot);
                val1=total;
                val2=Double.NaN;
                flagSub =false;*/
            }
            else  if(flagMul){
                total = total * val2;
                int newNumber = (int) total;
                if(newNumber>total||newNumber<total){
                    String tot = Double.toString(total);
                    calcScreen.setText(tot);
                    val1=total;
                    val2=Double.NaN;
                    flagMul = false;
                }
                else
                {
                    String tot = Integer.toString(newNumber);
                    calcScreen.setText(tot);
                    val1=newNumber;
                    val2=Double.NaN;
                    flagMul = false;
                }
            }
            else if(flagDiv) {
                if(val2==0){
                    calcScreen.setText("NaN");
                    val1=Double.NaN;
                    val2=Double.NaN;
                    flagDiv = false;
                }
                else{
                    total = total / val2;
                    int newNumber = (int) total;
                    if(newNumber>total||newNumber<total){
                        String tot = Double.toString(total);
                        calcScreen.setText(tot);
                        val1=total;
                        val2=Double.NaN;
                        flagDiv = false;
                    }
                    else
                    {
                        String tot = Integer.toString(newNumber);
                        calcScreen.setText(tot);
                        val1=newNumber;
                        val2=Double.NaN;
                        flagDiv = false;
                    }
                }
            }
            else if(flagPer){
                val2  = val2/100;
                total = total * val2;
                String tot = Double.toString(total);
                calcScreen.setText(tot);
                val1=total;
                val2=Double.NaN;
                flagPer = false;
            }
        }
        else{
            val1= Double.parseDouble(input);
            total = val1;
        }
    }

}
