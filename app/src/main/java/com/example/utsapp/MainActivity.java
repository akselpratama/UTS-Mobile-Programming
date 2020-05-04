package com.example.utsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class MainActivity extends AppCompatActivity {
    private EditText emailEditText;
    private EditText passEditText;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button=(Button)findViewById(R.id.btnlogin);

        emailEditText =(EditText)findViewById(R.id.txtusername);
        passEditText =(EditText)findViewById(R.id.txtpassword);
    }
    public void checklogin(View v) {
        final String email = emailEditText.getText().toString();
        switch (v.getId()) {
            case R.id.lingkaranHitung:
                hideKeybaord(v);
                break;
        }
        if (!isValidEmail(email)) {
            emailEditText.setError("Email Tidak Valid");
        }
        final String pass = passEditText.getText().toString();
        if (!isValidPassword(pass)) {
            passEditText.setError("Password tidak boleh kosong / lebih atau sama dengan 4 karakter");
        }
        if (isValidEmail(email) && isValidPassword(pass)) {
            Toast.makeText(getApplicationContext(), "Anda berhasil login ",Toast.LENGTH_LONG).show();
            Intent ExplicitIntent=new Intent(MainActivity.this, menu.class);
            startActivity(ExplicitIntent);
        }
    }
    private void hideKeybaord(View v) {
        InputMethodManager inputMethodManager = (InputMethodManager)getSystemService(INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(v.getApplicationWindowToken(),0);
    }

    public boolean isValidPassword (String password) {
        if (password != null && password.length() >= 4) {
            return true;
        }
        return false;
    }
    public boolean isValidEmail (String email) {
        String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}
