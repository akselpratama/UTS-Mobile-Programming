package com.example.utsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.view.inputmethod.InputMethodManager;

public class BangunDatar1 extends AppCompatActivity {
    EditText lingkaranDiameter;
    Button lingkaranHitung;
    TextView lingkaranHasilLuas, lingkaranHasilKeliling;
    Double diameter, jari2, luas, keliling;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bangun_datar1);
        lingkaranDiameter = (EditText) findViewById(R.id.lingkaranDiameter);
        lingkaranHitung = (Button) findViewById(R.id.lingkaranHitung);
        lingkaranHasilLuas = (TextView) findViewById(R.id.lingkaranHasilLuas);
        lingkaranHasilKeliling = (TextView) findViewById(R.id.lingkaranHasilKeliling);

        lingkaranHitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strdiameter=((EditText) lingkaranDiameter).getText().toString();
                switch (v.getId()) {
                    case R.id.lingkaranHitung:
                        hideKeybaord(v);
                        break;
                }
                if (lingkaranDiameter.length()==0) {
                    lingkaranDiameter.setError("Tidak Boleh Kosong!");
                }
                    else {
                    Toast.makeText(getApplicationContext(), "Berhasil Hitung!",Toast.LENGTH_LONG).show();
                    diameter=Double.parseDouble(strdiameter);

                    jari2= 0.5*diameter;
                    luas= 3.14*jari2*jari2;
                    keliling= 3.14*diameter;

                    lingkaranHasilLuas.setText(""+luas);
                    lingkaranHasilKeliling.setText(""+keliling);
                }
            }
            private void hideKeybaord(View v) {
                InputMethodManager inputMethodManager = (InputMethodManager)getSystemService(INPUT_METHOD_SERVICE);
                inputMethodManager.hideSoftInputFromWindow(v.getApplicationWindowToken(),0);
            }
        });
    }
    public void onclickBack(View arg0) {
        Intent ExplicitIntent=new Intent(BangunDatar1.this, menu.class);
        startActivity(ExplicitIntent);
    }
}
