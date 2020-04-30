package fr.epsi.demo;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import fr.epsi.demo.model.Student;

public class StudentActivity extends DemoActivity {
    private static Student students;


    public static void display(DemoActivity demoActivity, Student etudiant) {
        Intent intent=new Intent(demoActivity,StudentActivity.class);
        intent.putExtra("etudiant",etudiant);
        demoActivity.startActivity(intent);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.c_student);
        showBackBtn();

        students=(Student) getIntent().getExtras().get("etudiant");
        //Titre
        setTitle(students.getNom());
        TextView textViewNom= findViewById(R.id.Nom);
        //Infos etudiant
        textViewNom.setText(students.getNom()+" "+students.getPrenom());

        //Email etudiant
        TextView textViewEmail= findViewById(R.id.Email);
        textViewEmail.setText(students.getEmail());

        TextView textViewGroupe = findViewById(R.id.Groupe);
        textViewGroupe.setText(students.getGroupe());
        
        ImageView imageViewAvatar = findViewById(R.id.Photo);

        //Changement de photo selon le prenom
        switch (students.getPrenom()) {
            case "Maxime":
                imageViewAvatar.setImageResource(R.drawable.maxime);
                break;
            case "Andrea":
                imageViewAvatar.setImageResource(R.drawable.andrea);
                break;

        }
    }
}