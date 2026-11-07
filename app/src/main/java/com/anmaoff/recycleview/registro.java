package com.anmaoff.recycleview;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.anmaoff.recycleview.modelo.Conexion;
import com.anmaoff.recycleview.modelo.producto;
import com.anmaoff.recycleview.vistas.MainActivity;

public class registro extends AppCompatActivity {

    EditText txtClave, txtCantidad, txtPrecio, txtName, txtCategoria, txtDescripcion, txtResponsable;
    Button btnGuardar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_registro);

        txtClave = findViewById(R.id.txtClave);
        txtCantidad = findViewById(R.id.txtCantidad);
        txtPrecio = findViewById(R.id.txtPrecio);
        txtName = findViewById(R.id.txtName);
        txtCategoria = findViewById(R.id.txtCategoria);
        txtDescripcion = findViewById(R.id.txtDescripcion);
        txtResponsable = findViewById(R.id.txtResponsable);
        btnGuardar = findViewById(R.id.btnGuardar);

        btnGuardar.setOnClickListener(new View.OnClickListener() {
                                          @Override
                                          public void onClick(View v) {

                                              Conexion conexion = new Conexion( registro.this);
                                              producto producto = new producto();

                                              producto.setClave(Integer.parseInt(txtClave.getText().toString().trim()));
                                              producto.setCantidad(Integer.parseInt(txtCantidad.getText().toString().trim()));
                                              producto.setPrecio(Double.parseDouble(txtPrecio.getText().toString().trim()));
                                              producto.setName(txtName.getText().toString().trim());
                                              producto.setCategoria(txtCategoria.getText().toString().trim());
                                              producto.setDescripcion(txtDescripcion.getText().toString().trim());
                                              producto.setResponsable(txtResponsable.getText().toString().trim());

                                              conexion.agregar(producto);

                                              Intent intent = new Intent(registro.this, MainActivity.class);
                                              startActivity(intent);


                                          }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}