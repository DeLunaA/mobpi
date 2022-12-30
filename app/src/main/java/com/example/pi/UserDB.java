package com.example.pi;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class UserDB {
    private static final int VERSION_BDD = 1;
    private static final String NOM_BDD = "newpi.db";

    private static final String TABLE_USER = "table_user";

    private static final String COL_Tel = "Tel";
    private static final int NUM_COL_Tel = 0;

    private static final String COL_Prenom = "Prenom";
    private static final int NUM_COL_Prenom = 1;

    private static final String COL_Nom = "Nom";
    private static final int NUM_COL_Nom = 2;

    private static final String COL_Email = "Email";
    private static final int NUM_COL_Email = 3;

    private static final String COL_Mdp = "Mdp";
    private static final int NUM_COL_Mdp = 4;

    //creation base de données
    private SQLiteDatabase bdd;

    //jebneha mn MaBaseSQLite l stucture de bd

    private User.MaBaseSQLitee maBaseSQLite;

    public UserDB(Context context) {
        //On créer la BDD et sa table et on va declencher method maBaseSQLite et apres elle va aussi declencher onCreate et onUpgrade
        maBaseSQLite = new User.MaBaseSQLitee(context, NOM_BDD, null, VERSION_BDD);
    }


    public void open() {
        //on ouvre la BDD en écriture (théoriquement) et lecture
        bdd = maBaseSQLite.getWritableDatabase();

        //NB : pour ouvrir la BDD en lire seulement
        //bdd = maBaseSQLite.getReadableDatabase();
    }

    public void close() {
        //on ferme l'accès à la BDD (fermer la connection)
        bdd.close();
    }

    public SQLiteDatabase getBDD() {

        return bdd;
    }

    public long insertUser(User user) {
        //Création d'un ContentValues
        ContentValues values = new ContentValues();
        //on lui ajoute une valeur associé à une clé (qui est le nom de la colonne dans laquelle on veut mettre la valeur)

        values.put(COL_Tel, user.getTel());
        values.put(COL_Prenom, user.getPrenom());
        values.put(COL_Nom, user.getNom());
        values.put(COL_Email, user.getEmail());
        values.put(COL_Mdp, user.getMdp());
        //on insère l'objet dans la BDD via le ContentValues
        //null maneha zid f ekher l table
        return bdd.insert(TABLE_USER, null, values);
    }

    public int getnbrUser() {
        //cursor c'est un enregistrement PLSQL
        Cursor c = bdd.rawQuery("select * from " + TABLE_USER, new String[]{});
        //combien de ligne dans cursor
        //elle va faire conversion de type cursor a user car dans notre application on traite des object de type user
        return c.getCount();
    }


    public Boolean checkuser(String etel) {
        Cursor m = bdd.rawQuery("select * from table_user where Tel = ? ", new String[]{etel});

        if (m.getCount() > 0)
            return true;
        else
            return false;


    }

    public Boolean checkuserpass(String eEmail, String ePassword) {
        Cursor m = bdd.rawQuery("select * from table_user where Mdp= ? and  Email = ? ", new String[]{ePassword,eEmail });

        if (m.getCount() > 0)
            return true;
        else
            return false;


    }

    public Boolean checkuserEmail(String eEmail) {

        Cursor q = bdd.rawQuery("select * from TABLE_USER where Email= ?" , new String[]{eEmail});
        if (q.getCount() > 0)
            return true;
        else
            return false;
    }

    public Boolean updatepass(String Email,String pass){
        ContentValues contentValues=new ContentValues();
        contentValues.put("Mdp",pass);
        long result=bdd.update("TABLE_USER",contentValues,"Email=?",new String[]{Email});
        if (result==-1)
            return false;
        else
            return true;
    }




    public User getUserWithTelephone(String Tel) {
        //Récupère dans un Cursor les valeur correspondant à un etudiant contenu dans la BDD (ici on sélectionne le etudiant grâce à son prenom)
        Cursor f = bdd.query(TABLE_USER, new String[]{"Nom", "Prenom", "Tel", "Email", "Mdp"}, "Tel=?", new String[]{String.valueOf(Tel)},
                null, null, null, null);
        // on choisit cette methode ou l'autres mais celle la est préferable
        //Cursor c = bdd.query("select * from "+TABLE_USER+" where username= "+username,new String[]{});

        if (f.getCount() == 0)
            return null;

        f.moveToFirst();

        User user = new User(f.getString(0), f.getString(1), f.getString(2), f.getString(3), f.getString(4));
        return user;

    }


    public User getUserWithEmail(String email) {
        //Récupère dans un Cursor les valeur correspondant à un etudiant contenu dans la BDD (ici on sélectionne le etudiant grâce à son prenom)
        Cursor em = bdd.query(TABLE_USER, new String[]{COL_Nom, COL_Prenom, COL_Tel, COL_Email, COL_Mdp}, COL_Email
                + " LIKE \"" + email + "\"", null, null, null, null);
        // on choisit cette methode ou l'autres mais celle la est préferable
        //Cursor c = bdd.query("select * from "+TABLE_USER+" where username= "+username,new String[]{});
        return cursorToUser(em);
    }

    public User getUserWithusername(String nom) {
        //Récupère dans un Cursor les valeur correspondant à un etudiant contenu dans la BDD (ici on sélectionne le etudiant grâce à son prenom)
        Cursor c = bdd.query(TABLE_USER, new String[]{COL_Nom, COL_Prenom, COL_Tel, COL_Email, COL_Mdp}, COL_Email
                + " LIKE \"" + nom + "\"", null, null, null, null);
        return cursorToUser(c);
    }


    //to translate from cursor to user object
    private User cursorToUser(Cursor c) {
        //si aucun élément n'a été retourné dans la requête, on renvoie null
        if (c.getCount() == 0)
            return null;

        //Sinon on se place sur le premier élément
        c.moveToFirst();
        //On créé un etudiant (user)
        User user = new User();
        //meme mais en autre facon
        //String firstname=c.getString(1);
        //user.setFirstname(firstname);
        //on lui affecte toutes les infos grâce aux infos contenues dans le Cursor
        //user.set(c.getInt(NUM_COL_ID));
        user.setNom(c.getString(NUM_COL_Nom));
        user.setPrenom(c.getString(NUM_COL_Prenom));
        user.setTel(c.getString(NUM_COL_Tel));
        user.setEmail(c.getString(NUM_COL_Email));
        user.setMdp(c.getString(NUM_COL_Mdp));
        //On ferme le cursor
        c.close();

        //On retourne le user
        return user;
    }

    public Boolean checkusertel(String e) {
        Cursor q = bdd.rawQuery("select * from TABLE_USER where Tel= ?" , new String[]{e});
        if (q.getCount() > 0)
            return true;
        else
            return false;

    }






}
