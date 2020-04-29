package fr.epsi.demo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import fr.epsi.demo.model.Student;

public class EtudiantsActivity extends DemoActivity {
    private View.OnClickListener  groupButtonOnClick = new View.OnClickListener(){
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.Maxime:
                    StudentActivity.display(EtudiantsActivity.this, new Student("HOLEC","Maxime","maxime.holec@epsi.fr"));
                    break;
                case R.id.Andrea:
                    StudentActivity.display(EtudiantsActivity.this, new Student("Cicirello","Andrèa","andrea.cicirello@epsi.fr"));
                    break;
            }
        }
    };


    public static void display(DemoActivity activity){
        Intent intent=new Intent(activity,EtudiantsActivity.class);
        activity.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_etudiants);
        showBackBtn();
        findViewById(R.id.Maxime).setOnClickListener(groupButtonOnClick);
        findViewById(R.id.Andrea).setOnClickListener(groupButtonOnClick);
        setTitle("Infos");
    }
}
