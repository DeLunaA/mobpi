package com.example.pi;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class MaBaseSQLite extends SQLiteOpenHelper {
    private static final String TABLE_USER = "table_user";
    private static final String COL_Nom = "Nom";
    private static final String COL_Prenom = "Prenom";
    private static final String COL_Tel = "Tel";
    private static final String COL_Email = "Email";
    private static final String COL_Mdp = "Mdp";

    private static final String CREATE_TABLE_USER = "CREATE TABLE " + TABLE_USER + " ("
            + COL_Nom + " TEXT," + COL_Prenom
            + " TEXT, " + COL_Tel
            + " TEXT PRIMARY KEY, " + COL_Email + " TEXT NOT NULL,"
            + COL_Mdp + " TEXT NOT NULL);" ;

    private static final String update_db = "DROP TABLE " + TABLE_USER + ";";

    public MaBaseSQLite(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }


    @Override
    public void onCreate (SQLiteDatabase db){
        db.execSQL(CREATE_TABLE_USER);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVision){
        //remove the data base
        db.execSQL(update_db);

        //then recreate it by :
        onCreate(db);
    }



}
