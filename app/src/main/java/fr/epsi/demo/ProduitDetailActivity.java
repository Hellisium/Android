package fr.epsi.demo;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import fr.epsi.demo.model.Produit;

public class ProduitDetailActivity extends DemoActivity {

    private Produit produits;

    public static void display(DemoActivity activity, Produit produits){
        Intent intent = new Intent(activity, ProduitDetailActivity.class);
        intent.putExtra("produits",produits);
        activity.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_des_produits);
        showBackBtn();

        produits = (Produit) getIntent().getExtras().get("produits");

        ImageView imageViewProduct = findViewById(R.id.imageViewProduct);
        Picasso.get().load(produits.getImageUrl()).into(imageViewProduct);

        TextView textViewDescription = findViewById(R.id.textViewDescription);
        textViewDescription.setText(produits.getDescription());



    }
}
