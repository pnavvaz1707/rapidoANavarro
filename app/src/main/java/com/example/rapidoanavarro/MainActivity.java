package com.example.rapidoanavarro;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    ArrayList<Personal> personal = new ArrayList<>();
    ArrayList<Coche> coches = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_window);

        recogerDatos();

        AdaptadorPersonal adaptadorPersonal = new AdaptadorPersonal(this, personal, coches);
        ListView personalLista = (ListView) findViewById(R.id.personal_lista);
        personalLista.setAdapter(adaptadorPersonal);

    }


    private void recogerDatos() {
        recogerDatosPersonal();
        recogerDatosCoches();
    }

    private void recogerDatosCoches() {

        ArrayList<String> marcasCoches = new ArrayList<>(Arrays.asList(getResources().getStringArray(R.array.cochesMarca)));
        ArrayList<String> coloresCoches = new ArrayList<>(Arrays.asList(getResources().getStringArray(R.array.cochesColor)));

        for (int i = 0; i < marcasCoches.size(); i++) {
            String marca = marcasCoches.get(i);
            String color = coloresCoches.get(i);

            coches.add(new Coche(marca, color));
        }
    }

    private void recogerDatosPersonal() {

        ArrayList<String> nombresPersonal = new ArrayList<>(Arrays.asList(getResources().getStringArray(R.array.personalNombres)));
        ArrayList<String> cargosPersonal = new ArrayList<>(Arrays.asList(getResources().getStringArray(R.array.personalCargos)));
        ArrayList<String> sueldoPersonal = new ArrayList<>(Arrays.asList(getResources().getStringArray(R.array.personalSueldo)));

        for (int i = 0; i < nombresPersonal.size(); i++) {
            String nombre = nombresPersonal.get(i);
            String cargo = cargosPersonal.get(i);
            int sueldo = Integer.parseInt(sueldoPersonal.get(i));

            personal.add(new Personal(nombre, cargo, sueldo));

        }
    }
}
