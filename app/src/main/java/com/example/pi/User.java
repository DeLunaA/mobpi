package com.example.pi;

public class User {
    private String Nom;
    private String Prenom;
    private String Tel;
    private String Email;
    private String Mdp;

    public User(String Nom, String Prenom, String Tel, String Email, String Mdp) {
        this.Nom = Nom;
        this.Prenom = Prenom;
        this.Tel = Tel;
        this.Email = Email;
        this.Mdp = Mdp;
    }

    public User() {
    }

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


}

