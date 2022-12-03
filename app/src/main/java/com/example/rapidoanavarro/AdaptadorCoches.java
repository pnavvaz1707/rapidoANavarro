package com.example.rapidoanavarro;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class AdaptadorCoches extends ArrayAdapter {
    private Activity context;
    private ArrayList<Coche> datos;

    public AdaptadorCoches(Activity context, ArrayList<Coche> datos) {
        super(context, R.layout.adaptador_coches, datos);
        this.context = context;
        this.datos = datos;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View item = inflater.inflate(R.layout.adaptador_coches, null);

        TextView tvCoche = (TextView) item.findViewById(R.id.tvCoche);
        tvCoche.setText(datos.get(position).getMarca());

        return (item);
    }

}
