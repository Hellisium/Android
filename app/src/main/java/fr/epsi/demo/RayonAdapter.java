package fr.epsi.demo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.List;

import fr.epsi.demo.model.Rayon;

public class RayonAdapter extends ArrayAdapter {
    public RayonAdapter(@NonNull Context context, int ressource, @NonNull List<Rayon> objects){
        super(context,ressource,objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
        LayoutInflater li = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView =  li.inflate(R.layout.c_rayon, null);

        TextView textViewName=convertView.findViewById(R.id.textViewName);

        Rayon rayons = (Rayon) getItem(position);

        textViewName.setText(rayons.getTitle());

        return convertView;
    }
}
