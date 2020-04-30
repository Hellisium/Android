package fr.epsi.demo.model;

import org.json.JSONObject;

import java.io.Serializable;

public class Student implements Serializable {
    private String nom="";
    private String prenom="";
    private String email="";
    private String groupe="";



    public Student(String nom, String prenom, String email, String groupe) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.groupe = groupe;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGroupe() { return groupe; }

    public void setGroupe(String groupe) { this.groupe = groupe; }





}
