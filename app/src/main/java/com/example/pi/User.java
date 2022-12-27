package com.example.pi;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class User {
    private String Nom;
    private String Prenom;
    private String Tel;
    private String Email;
    private String Mdp;


    public String getNom() {
        return Nom;
    }

    public String getPrenom() {
        return Prenom;
    }

    public String getTel() {
        return Tel;
    }

    public String getEmail() {
        return Email;
    }

    public String getMdp() {return Mdp;}

    public void setNom(String Nom) {
        this.Nom = Nom;
    }

    public void setPrenom(String Prenom) {
        this.Prenom = Prenom;
    }

    public void setTel(String Tel) {
        this.Tel = Tel;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public void setMdp(String Mdp) {
        this.Mdp = Mdp;
    }


    public User(String Nom, String Prenom, String Tel, String Email, String Mdp) {
        this.Nom = Nom;
        this.Prenom = Prenom;
        this.Tel = Tel;
        this.Email = Email;
        this.Mdp = Mdp;
    }

    public User() {
    }

    public static class MaBaseSQLitee extends SQLiteOpenHelper {


        private static final String TABLE_USER = "table_user";
        private static final String COL_Nom = "Nom";
        private static final String COL_Prenom = "Prenom";
        private static final String COL_Tel = "Tel";
        private static final String COL_Email = "Email";
        private static final String COL_Mdp = "Mdp";

        public MaBaseSQLitee(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
            super(context, name, factory, version);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {

            db.execSQL("CREATE TABLE " + TABLE_USER + " ("
                    + COL_Nom + " TEXT," + COL_Prenom
                    + " TEXT, " + COL_Tel
                    + " TEXT PRIMARY KEY, " + COL_Email + " TEXT NOT NULL,"
                    + COL_Mdp + " TEXT NOT NULL);");
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int i, int i1) {


            db.execSQL("DROP TABLE " + TABLE_USER + ";");
            onCreate(db);


        }
    }



}

