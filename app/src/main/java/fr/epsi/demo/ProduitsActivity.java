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

import fr.epsi.demo.model.Produit;
import fr.epsi.demo.model.Rayon;

public class ProduitsActivity extends DemoActivity {

    private ArrayList<Produit> produits;
    private ProduitAdapter ProduitAdapter ;

    public static void display(DemoActivity activity, Rayon rayons){
        Intent intent = new Intent(activity, ProduitsActivity.class);
        intent.putExtra("rayons",rayons);
        activity.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_des_produits);
        Rayon rayons = (Rayon) getIntent().getExtras().get("rayons");
        produits = new ArrayList<>();
        showBackBtn();

        setTitle(rayons.getTitle());
        ListView listView = findViewById(R.id.listViewProducts);
        ProduitAdapter = new ProduitAdapter(this,R.layout.c_produits, produits);
        listView.setAdapter(ProduitAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ProduitDetailActivity.display(ProduitsActivity.this,produits.get(position));
            }
        });

        String url = rayons.getUrl();


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
                Produit produit =new Produit(jsonArray.getJSONObject(i));
                produits.add(produit);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ProduitAdapter.notifyDataSetChanged();
    }
}

