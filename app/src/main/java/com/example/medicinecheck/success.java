package com.example.medicinecheck;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
public class success extends AppCompatActivity {

    Button btninsert, btntrigger;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success);
        btninsert = findViewById(R.id.btn_insert);
        btntrigger = findViewById(R.id.btn_trigger);
        btninsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(success.this,insertdata.class);
                startActivity(it); }
        });
        btntrigger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent trigger = new Intent(success.this,triggeractivity.class);
                startActivity(trigger); }
        }); } }