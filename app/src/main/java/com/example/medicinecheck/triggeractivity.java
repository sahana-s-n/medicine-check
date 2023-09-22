package com.example.medicinecheck;

import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
public class triggeractivity extends AppCompatActivity {
   // MediaPlayer play;
    EditText txtdate,txtday;
    Button btntrigger;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_triggeractivity);
       // play= new MediaPlayer().create(triggeractivity.this,R.raw.alarmsong);
        txtdate = findViewById(R.id.editText);
        txtday = findViewById(R.id.editText1);
        btntrigger = findViewById(R.id.button3);

        btntrigger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String datetrg = txtdate.getText().toString().trim();
                String timeofday = txtday.getText().toString().trim();
                MedicineHelper helper = new MedicineHelper(getBaseContext(), MedicineHelper.DATABASE_NAME, null, 1);
                SQLiteDatabase database = helper.getWritableDatabase();
                @SuppressLint("Recycle") Cursor res = database.rawQuery("select * from Medicine where Medicine.date = ? and Medicine.time = ? COLLATE NOCASE", new String[]{datetrg,timeofday});
                if(res.getCount() == 0) {
                    Toast.makeText(getBaseContext(), "No DATA ",Toast.LENGTH_LONG).show(); }
                    while (res.moveToNext())
                    {
                        Intent intent = new Intent(triggeractivity.this, AlarmF.class);
                        @SuppressLint("UnspecifiedImmutableFlag") PendingIntent pendingIntent = PendingIntent.getBroadcast(getBaseContext(), 234324243, intent, 0);
                        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
                        alarmManager.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() + (1 * 1000), pendingIntent);
                        Toast.makeText(getBaseContext(), "Alarm set in 1 seconds",Toast.LENGTH_LONG).show();
                                Toast.makeText(getBaseContext(), "Time to take "+ res.getString(0)+ " Medicine : "+res.getString(2),Toast.LENGTH_LONG).show();
                    } }
            });

    } }