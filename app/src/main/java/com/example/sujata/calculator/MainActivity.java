package com.example.sujata.calculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText email,password;
    public static final String LOGIN_DATA="login_data";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        email=(EditText)findViewById(R.id.email);
        password=(EditText)findViewById(R.id.password);
    }
    public void onButtonClick(View view){


         if (view.getId()==R.id.login){
            if((isValidEmail(email.getText().toString()))&&(isValidPassword(password.getText().toString())))
            {
                Intent i = new Intent(MainActivity.this, Calculator.class);
                String s = email.getText().toString();
                String p = password.getText().toString();
                i.putExtra(LOGIN_DATA, s);
                startActivity(i);
            }
            else {
                Toast.makeText(this, "Wrong Email or Password", Toast.LENGTH_SHORT).show();
            }
        }


    }
    public static boolean isValidEmail(CharSequence target) {
        return (!TextUtils.isEmpty(target) && Patterns.EMAIL_ADDRESS.matcher(target).matches());
    }
    public static boolean isValidPassword(CharSequence target){
        return (!TextUtils.isEmpty(target)&& target.length()>=8);
    }
}
