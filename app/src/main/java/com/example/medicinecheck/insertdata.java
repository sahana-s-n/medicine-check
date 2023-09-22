package com.example.medicinecheck;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
public class insertdata extends AppCompatActivity {
    Button btninsert,btnhomepage;
    EditText medname, meddate, medtime;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insertdata);
        medname = findViewById(R.id.editText);
        meddate = findViewById(R.id.editText1);
        medtime = findViewById(R.id.editText2);
        btninsert = findViewById(R.id.button);
        btnhomepage = findViewById(R.id.buttonhome);
        btninsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String medicinename = medname.getText().toString();
                String medicinedate = meddate.getText().toString();
                String medicinetime = medtime.getText().toString();
                MedicineHelper helper = new MedicineHelper(getBaseContext(), MedicineHelper.DATABASE_NAME, null, 1);
                SQLiteDatabase database = helper.getWritableDatabase();
                ContentValues cv = new ContentValues();
                cv.put("name",medicinename);
                cv.put("date",medicinedate);
                cv.put("time",medicinetime);
                database.insert("Medicine",null,cv);
                Toast.makeText(getBaseContext(),"Record inserted successfully",Toast.LENGTH_LONG).show(); }
            });
             btnhomepage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent home = new Intent(insertdata.this,success.class);
                    startActivity(home);
                }
            });
        }
    }