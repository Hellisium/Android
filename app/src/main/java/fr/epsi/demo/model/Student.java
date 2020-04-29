package fr.epsi.demo.model;

import org.json.JSONObject;

import java.io.Serializable;

public class Student implements Serializable {
    private String photo="";
    private String nom="";
    private String prenom="";
    private String email="";

    public Student(String nom, String prenom, String email) {
        nom = nom;
        prenom = prenom;
        email = email;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
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





}
