package fr.epsi.demo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import fr.epsi.demo.model.Rayon;

public class RayonActivity extends DemoActivity{
    private RayonAdapter rayonAdapter;
    private ArrayList<Rayon> rayons;

    public static void display(DemoActivity activity){
        Intent intent=new Intent(activity, RayonActivity.class);
        activity.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_categorie);
        showBackBtn();
        setTitle("Rayons");
        rayons = new ArrayList<>();
        ListView listView = findViewById(R.id.listViewCategorie);
        rayonAdapter = new RayonAdapter(this, R.layout.c_rayon,rayons);
        listView.setAdapter(rayonAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ProduitsActivity.display(RayonActivity.this,rayons.get(position));
            }
        });

        String url = "http://djemam.com/epsi/categories.json";

        new HttpAsyTask(url, new HttpAsyTask.HttpAsyTaskListener() {
            @Override
            public void webServiceDone(String result) {
                initData(result);
            }

            @Override
            public void webServiceError(Exception e) {
                displayToast(e.getMessage());
            }
        }).execute();

    }
    private void initData(String data) {
        try {
            JSONObject jsonObject;
            jsonObject=new JSONObject(data);
            JSONArray jsonArray=jsonObject.getJSONArray("items");
            for(int i=0;i<jsonArray.length();i++){
                Rayon rayon=new Rayon(jsonArray.getJSONObject(i));
                rayons.add(rayon);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        displayToast(String.valueOf(rayons.size()));
        rayonAdapter.notifyDataSetChanged();
    }
}
