package com.example.utsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class BangunDatar2 extends AppCompatActivity {
    EditText persegiPanjang, persegiLebar;
    Button persegiHitung;
    TextView persegiHasilLuas, persegiHasilKeliling;
    Double panjang, lebar, luas, keliling;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bangun_datar2);

        persegiPanjang = (EditText) findViewById(R.id.persegiPanjang);
        persegiLebar = (EditText) findViewById(R.id.persegiLebar);
        persegiHitung = (Button) findViewById(R.id.persegiHitung);
        persegiHasilLuas = (TextView) findViewById(R.id.persegiHasilLuas);
        persegiHasilKeliling = (TextView) findViewById(R.id.persegiHasilKeliling);

        persegiHitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strpanjang=((EditText) persegiPanjang).getText().toString();
                String strlebar=((EditText) persegiLebar).getText().toString();
                switch (v.getId()) {
                    case R.id.persegiHitung:
                        hideKeybaord(v);
                        break;
                }

                if (persegiPanjang.length()==0) {
                    persegiPanjang.setError("Tidak Boleh Kosong!");
                }  else if (persegiLebar.length()==0) {
                    persegiLebar.setError("Tidak Boleh Kosong!");
                }
                 else {
                    panjang=Double.parseDouble(strpanjang);
                    lebar=Double.parseDouble(strlebar);

                    luas= panjang*lebar;
                    keliling= (2*panjang)+(2*lebar);

                    persegiHasilLuas.setText(""+luas);
                    persegiHasilKeliling.setText(""+keliling);
                }
            }
            private void hideKeybaord(View v) {
                InputMethodManager inputMethodManager = (InputMethodManager)getSystemService(INPUT_METHOD_SERVICE);
                inputMethodManager.hideSoftInputFromWindow(v.getApplicationWindowToken(),0);
            }
        });
    }
    public void onclickBack(View arg0) {
        Intent ExplicitIntent=new Intent(BangunDatar2.this, menu.class);
        startActivity(ExplicitIntent);
    }
}
