package com.example.pi;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MaBaseSQLite extends SQLiteOpenHelper {
    private static final String TABLE_USER = "table_user";
    private static final String COL_Nom = "Nom";
    private static final String COL_Prenom = "Prenom";
    private static final String COL_Tel = "Tel";
    private static final String COL_Email = "Email";
    private static final String COL_Mdp = "Mdp";

    private static final String CREATE_TABLE_USER = "CREATE TABLE " + TABLE_USER + " ("
            + COL_Nom + " TEXT PRIMARY KEY," + COL_Prenom
            + "TEXT, " + COL_Tel
            + "TEXT, " + COL_Email + "TEXT NOT NULL,"
            + COL_Mdp + "TEXT NOT NULL);" ;

    public MaBaseSQLite(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }


    @Override
    public void onCreate (SQLiteDatabase db){
        db.execSQL(CREATE_TABLE_USER);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVision){
        db.execSQL("DROP TABLE " + TABLE_USER + ";");
        onCreate(db);
    }

}
