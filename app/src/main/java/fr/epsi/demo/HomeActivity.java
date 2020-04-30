package fr.epsi.demo;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;

public class HomeActivity extends DemoActivity implements View.OnClickListener {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        setContentView(R.layout.activity_home);
        super.onCreate(savedInstanceState);
        findViewById(R.id.Etudiants).setOnClickListener(this);
        findViewById(R.id.Magasin).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.Etudiants:
                EtudiantsActivity.display(HomeActivity.this);
                break;
            case R.id.Magasin:
                RayonActivity.display(HomeActivity.this);
                break;
        }
    }
}