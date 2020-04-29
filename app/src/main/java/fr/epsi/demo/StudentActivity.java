package fr.epsi.demo;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import fr.epsi.demo.model.Student;

public class StudentActivity extends DemoActivity {
    private Student students;

    public static void display(DemoActivity demoActivity, Student student) {
        Intent intent=new Intent(demoActivity,StudentActivity.class);
        intent.putExtra("student",student);
        demoActivity.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);
        showBackBtn();
        students=(Student) getIntent().getExtras().get("student");
        setTitle(students.getNom());
        TextView textViewNom= findViewById(R.id.Nom);
        textViewNom.setText(students.getNom()+" "+students.getPrenom());
        TextView textViewEmail= findViewById(R.id.Email);
        textViewEmail.setText(students.getEmail());
        ImageView imageViewAvatar = findViewById(R.id.Photo);

        switch (students.getNom()) {
            case "LEMERY":
                imageViewAvatar.setImageResource(R.drawable.ic_launcher_foreground);
                break;
            case "ARRAUD":
                imageViewAvatar.setImageResource(R.drawable.ic_launcher_foreground);
                break;

        }
    }
}