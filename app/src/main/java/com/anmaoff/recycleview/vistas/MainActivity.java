package com.anmaoff.recycleview.vistas;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.anmaoff.recycleview.R;
import com.anmaoff.recycleview.registro;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView lista;
    FloatingActionButton btnAgregar;

    List<String> nombre;
    List<String> telefonos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        lista = findViewById(R.id.lista);
        btnAgregar = findViewById(R.id.btnAgregar);
        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, registro.class);
                startActivity(intent);

            }
        });

        nombre = new ArrayList<String>();
        nombre.add("Fernanda");
        nombre.add("Guadalupe");
        nombre.add("Angel");
        nombre.add("Manuel");
        telefonos = new ArrayList<String>();
        telefonos.add("1111111111");
        telefonos.add("2222222222");
        telefonos.add("3333333333");
        telefonos.add("4444444444");

        int [] imagenes = {R.drawable.a1, R.drawable.a2, R.drawable.a3, R.drawable.a4};

        Adaptador adaptador = new Adaptador(this, nombre, telefonos, imagenes);

        lista.setAdapter(adaptador);
        lista.setLayoutManager(new LinearLayoutManager(this));

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}