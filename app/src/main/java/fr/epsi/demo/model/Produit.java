package fr.epsi.demo.model;

import org.json.JSONObject;

import java.io.Serializable;

public class Produit implements Serializable {
    private String name="";
    private String description="";
    private String imageUrl="";


    public Produit(JSONObject jsonObject){
        name=jsonObject.optString("name","");
        description=jsonObject.optString("description","");
        imageUrl=jsonObject.optString("picture_url","");

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;

    }
}
