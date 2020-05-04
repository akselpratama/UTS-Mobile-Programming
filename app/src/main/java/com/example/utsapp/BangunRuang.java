package com.example.utsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class BangunRuang extends AppCompatActivity {
    EditText balokPanjang, balokLebar, balokTinggi;
    Button balokHitung;
    TextView balokHasilVolume;
    Double panjang, lebar, tinggi, volume;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bangun_ruang);

        balokPanjang = (EditText) findViewById(R.id.balokPanjang);
        balokLebar = (EditText) findViewById(R.id.balokLebar);
        balokTinggi = (EditText) findViewById(R.id.balokTinggi);
        balokHitung = (Button) findViewById(R.id.balokHitung);
        balokHasilVolume = (TextView) findViewById(R.id.balokHasilVolume);

        balokHitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strpanjang=((EditText) balokPanjang).getText().toString();
                String strlebar=((EditText) balokLebar).getText().toString();
                String strtinggi=((EditText) balokTinggi).getText().toString();
                switch (v.getId()) {
                    case R.id.balokHitung:
                        hideKeybaord(v);
                        break;
                }

                if (balokPanjang.length()==0) {
                    balokPanjang.setError("Tidak Boleh Kosong!");
                }  else if (balokLebar.length()==0) {
                    balokLebar.setError("Tidak Boleh Kosong!");
                } else if (balokTinggi.length()==0) {
                    balokTinggi.setError("Tidak Boleh Kosong!");
                } else {
                    panjang=Double.parseDouble(strpanjang);
                    lebar=Double.parseDouble(strlebar);
                    tinggi=Double.parseDouble(strtinggi);

                    volume= panjang*lebar*tinggi;

                    balokHasilVolume.setText(""+volume);
                }
            }
            private void hideKeybaord(View v) {
                InputMethodManager inputMethodManager = (InputMethodManager)getSystemService(INPUT_METHOD_SERVICE);
                inputMethodManager.hideSoftInputFromWindow(v.getApplicationWindowToken(),0);
            }
        });
    }
    public void onclickBack(View arg0) {
        Intent ExplicitIntent=new Intent(BangunRuang.this, menu.class);
        startActivity(ExplicitIntent);
    }
}
