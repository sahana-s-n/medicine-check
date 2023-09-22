package com.example.medicinecheck;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
public class MedicineHelper extends SQLiteOpenHelper
{
    public static String DATABASE_NAME="MEDICINE.db";
    public static String MEDICINE_TABLE="Medicine";
    public static String MEDICINE_COLUMN1 = "name";
    public static String MEDICINE_COLUMN2 = "date";
    public static String MEDICINE_COLUMN3 = "time";
    public MedicineHelper(Context context, String name, SQLiteDatabase.CursorFactory
            factory, int version) {
        super(context, name, factory, version); }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table Medicine (name TEXT, date TEXT, time TEXT)"); }
        @Override
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
