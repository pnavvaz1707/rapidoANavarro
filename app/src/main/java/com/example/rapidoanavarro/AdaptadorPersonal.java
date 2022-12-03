package com.example.rapidoanavarro;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class AdaptadorPersonal extends ArrayAdapter {
    private Activity context;
    private ArrayList<Personal> datos;
    private ArrayList<Coche> coches;

    public AdaptadorPersonal(Activity context, ArrayList<Personal> datos, ArrayList<Coche> coches) {
        super(context, R.layout.adaptador_personal, datos);
        this.context = context;
        this.datos = datos;
        this.coches = coches;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View item = inflater.inflate(R.layout.adaptador_personal, null);

        TextView tvNombre = (TextView) item.findViewById(R.id.tvNombre);
        tvNombre.setText(datos.get(position).getNombre());

        TextView tvCargo = (TextView) item.findViewById(R.id.tvCargo);
        tvCargo.setText(datos.get(position).getCargo());

        TextView tvSueldo = (TextView) item.findViewById(R.id.tvSueldo);
        tvSueldo.setText(String.valueOf(datos.get(position).getSueldo()));

        ArrayList<Coche> cochesPosibles = new ArrayList<>();

        for (Coche coche : coches) {
            if (datos.get(position).equals("Informático")) {
                cochesPosibles.add(coche);
            } else {

                if (datos.get(position).getSueldo() >= 2000) {

                    if (coche.getColor().equals("Negro") || coche.getColor().equals("Blanco")) {
                        cochesPosibles.add(coche);
                    }
                } else if (!(coche.getColor().equals("Negro")) && !(coche.getColor().equals("Blanco"))) {
                    cochesPosibles.add(coche);
                }
            }

        }
        AdaptadorCoches adaptadorCoches = new AdaptadorCoches(context, cochesPosibles);
        ListView cochesLista = (ListView) item.findViewById(R.id.cochesList);
        cochesLista.setAdapter(adaptadorCoches);

        return (item);
    }
}
