package fr.epsi.demo.model;

import org.json.JSONObject;

import java.io.Serializable;

public class Rayon implements Serializable {

    private String title="";
    private String url="";


    public Rayon(JSONObject jsonObject){
        title=jsonObject.optString("title","");
        url=jsonObject.optString("products_url","");

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
