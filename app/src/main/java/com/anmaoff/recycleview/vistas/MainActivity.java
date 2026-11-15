package com.anmaoff.recycleview.vistas;

import android.content.Intent;
import android.database.Cursor;
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
import com.anmaoff.recycleview.modelo.Conexion;
import com.anmaoff.recycleview.registro;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView lista;
    FloatingActionButton btnAgregar;
    Conexion conexion;
    ArrayList<String> Clave;
    ArrayList<String> Name;
    ArrayList<String> Cantidad;
    ArrayList<String> Precio;
    ArrayList<String> Categoria;
    ArrayList<String> Descripcion;
    ArrayList<String> Responsable;

    List<String> nombre;
    List<String> telefonos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        lista = findViewById(R.id.lista);
        btnAgregar = findViewById(R.id.btnAgregar);
        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, registro.class);
                startActivity(intent);
            }
        });

        conexion = new Conexion(this);

        Clave = new ArrayList<String>();
        Name = new ArrayList<String>();
        Cantidad = new ArrayList<String>();
        Precio = new ArrayList<String>();
        Categoria = new ArrayList<String>();
        Descripcion = new ArrayList<String>();
        Responsable = new ArrayList<String>();

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

        int[] imagenes = {R.drawable.a1, R.drawable.a2, R.drawable.a3, R.drawable.a4};

        prepararDatos();

        Adaptador adaptador = new Adaptador(this, nombre, telefonos, imagenes,
                Clave, Name, Cantidad, Precio, Categoria, Descripcion, Responsable);

        lista.setAdapter(adaptador);
        lista.setLayoutManager(new LinearLayoutManager(this));
    }

    void prepararDatos() {

        Cursor cursor = conexion.consultar();
        if (cursor.getCount() != 0) {
            while (cursor.moveToNext()) {

                Clave.add("" + cursor.getInt(0));
                Name.add(cursor.getString(1));
                Cantidad.add("" + cursor.getInt(2));
                Precio.add("" + cursor.getDouble(3));
                Categoria.add(cursor.getString(4));
                Descripcion.add(cursor.getString(5));
                Responsable.add(cursor.getString(6));
                nombre.add(cursor.getString(1));
                telefonos.add("Precio: $" + cursor.getDouble(3));
            }
        }
        cursor.close();
    }
}