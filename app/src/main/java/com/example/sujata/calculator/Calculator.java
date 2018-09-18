package com.example.sujata.calculator;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Calculator extends MainActivity{
    TextView textView;
    int flag=0;
    int a;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculator);
        textView=(TextView)findViewById(R.id.textView);
        Intent i = getIntent();
        String s = i.getStringExtra(MainActivity.LOGIN_DATA);
        Toast.makeText(this, "LOGIN" , Toast.LENGTH_SHORT).show();
    }
    private void calc(int a,int b,int flag){
        int c;
        switch (flag){
            case 1: {
                c = a + b;
                textView.setText("" + c);
                break;
            }
            case 2:
            {
                c = a - b;
                textView.setText("" + c);
                break;
            }
            case 3: {
                c = a * b;
                textView.setText("" + c);
                break;
            }
            case 4:
            {
                if(b==0){
                    textView.setText("CAN'T DIVIDE BY Zero");
                }
                else{
                    c=a/b;
                    textView.setText(""+c);
                }
                break;
            }
        }
    }
    public void onClick(View v){
        if (v.getId() == R.id.one) {
            textView.setText(textView.getText().toString()+"1");
        }
        if(v.getId()==R.id.two){
            textView.setText(textView.getText().toString()+"2");
        }
        if(v.getId()==R.id.three){
            textView.setText(textView.getText().toString()+"3");
        }
        if(v.getId()==R.id.four){
            textView.setText(textView.getText().toString()+"4");
        }
        if(v.getId()==R.id.five){
            textView.setText(textView.getText().toString()+"5");
        }
        if(v.getId()==R.id.six){
            textView.setText(textView.getText().toString()+"6");
        }
        if(v.getId()==R.id.seven){
            textView.setText(textView.getText().toString()+"7");
        }
        if(v.getId()==R.id.eight){
            textView.setText(textView.getText().toString()+"8");
        }
        if(v.getId()==R.id.nine){
            textView.setText(textView.getText().toString()+"9");
        }
        if(v.getId()==R.id.zero){
            textView.setText(textView.getText().toString()+"0");
        }
        if(v.getId()==R.id.add){
            a=Integer.parseInt(textView.getText().toString());
            textView.setText("");
            flag=1;
        }
        if(v.getId()==R.id.minus){
            a=Integer.parseInt(textView.getText().toString());
            textView.setText("");
            flag=2;
        }
        if(v.getId()==R.id.multiply){
            a=Integer.parseInt(textView.getText().toString());
            textView.setText("");
            flag=3;
        }
        if(v.getId()==R.id.division){
            a=Integer.parseInt(textView.getText().toString());
            textView.setText("");
            flag=4;
        }
        if (v.getId()==R.id.equal){
            int b;
            if (textView.getText().toString().length()==0){
                b=0;
            }
            else {
                b = Integer.parseInt(textView.getText().toString());
            }
            calc(a,b,flag);
        }
        if (v.getId()==R.id.clr){
            textView.setText("");
        }
    }
}
