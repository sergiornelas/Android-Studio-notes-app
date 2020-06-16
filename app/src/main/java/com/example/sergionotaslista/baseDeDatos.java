package com.example.sergionotaslista;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

    public class baseDeDatos extends SQLiteOpenHelper {

        public static final String DATABASE_NAME = "notas.db";
        public static final String TABLE_NAME = "notas_datos";
        public static final String COL1 = "ID";
        public static final String COL2 = "NOTA1";


        public baseDeDatos(Context context) {
            super(context, DATABASE_NAME, null, 1);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            String createTable = "CREATE TABLE " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    " NOTA1 TEXT)";
            db.execSQL(createTable);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            //db.execSQL("DROP IF TABLE EXISTS " + TABLE_NAME);
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
            onCreate(db);
        }


        public boolean añadirDatos(String nota1) {
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put(COL2, nota1);

            long resultado = db.insert(TABLE_NAME, null, contentValues);

            //if date as inserted incorrectly it will return -1
            if (resultado == -1) {
                return false;
            } else {
                return true;
            }
        }
        public Cursor getListContents(){
            SQLiteDatabase db = this.getWritableDatabase();
            Cursor data = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
            return data;
        }
    }