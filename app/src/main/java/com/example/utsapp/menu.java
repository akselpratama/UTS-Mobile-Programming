package com.example.utsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.utsapp.BangunDatar1;
import com.example.utsapp.BangunDatar2;
import com.example.utsapp.BangunRuang;
import com.example.utsapp.MainActivity;

public class menu extends AppCompatActivity {
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        button=(Button)findViewById(R.id.btnBangunDatar1);
        button=(Button)findViewById(R.id.btnBangunDatar2);
        button=(Button)findViewById(R.id.btnBangunRuang);
        button=(Button)findViewById(R.id.btnkeluar);
    }
    public void onclickBangunDatar1(View arg0) {
        Toast.makeText(getApplicationContext(), "Selamat Datang di Hitung Lingkaran",Toast.LENGTH_LONG).show();
        Intent ExplicitIntent=new Intent(menu.this, BangunDatar1.class);
        startActivity(ExplicitIntent);
    }
    public void onclickBangunDatar2(View arg0) {
        Toast.makeText(getApplicationContext(), "Selamat Datang di Hitung Persegi Panjang",Toast.LENGTH_LONG).show();
        Intent ExplicitIntent=new Intent(menu.this, BangunDatar2.class);
        startActivity(ExplicitIntent);
    }
    public void onclickBangunRuang(View arg0) {
        Toast.makeText(getApplicationContext(), "Selamat Datang di Hitung Balok",Toast.LENGTH_LONG).show();
        Intent ExplicitIntent=new Intent(menu.this, BangunRuang.class);
        startActivity(ExplicitIntent);
    }
    public void onclickkeluar(View arg0) {
        Toast.makeText(getApplicationContext(), "Anda Berhasil Keluar",Toast.LENGTH_LONG).show();
        Intent ExplicitIntent=new Intent(menu.this, MainActivity.class);
        startActivity(ExplicitIntent);
    }
}
