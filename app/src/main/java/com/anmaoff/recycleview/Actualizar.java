package com.anmaoff.recycleview;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;

import com.anmaoff.recycleview.modelo.Conexion;
import com.anmaoff.recycleview.modelo.producto;
import com.anmaoff.recycleview.vistas.MainActivity;

public class Actualizar extends AppCompatActivity {

    EditText txtMClave, txtMCantidad, txtMPrecio, txtMName, txtMCategoria, txtMDescripcion, txtMResponsable;
    Button btnActualizar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        WindowCompat.enableEdgeToEdge(getWindow());
        setContentView(R.layout.activity_actualizar);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        txtMClave = findViewById(R.id.txtClave2);
        txtMCantidad = findViewById(R.id.txtCantidad2);
        txtMPrecio = findViewById(R.id.txtPrecio2);
        txtMName = findViewById(R.id.txtName2);
        txtMCategoria = findViewById(R.id.txtCategoria2);
        txtMDescripcion = findViewById(R.id.txtDescripcion2);
        txtMResponsable = findViewById(R.id.txtResponsable2);
        btnActualizar = findViewById(R.id.btnActualizar);

        txtMClave.setText(getIntent().getStringExtra("Clave"));
        txtMCantidad.setText(getIntent().getStringExtra("Cantidad"));
        txtMPrecio.setText(getIntent().getStringExtra("Precio"));
        txtMName.setText(getIntent().getStringExtra("Name"));
        txtMCategoria.setText(getIntent().getStringExtra("Categoria"));
        txtMDescripcion.setText(getIntent().getStringExtra("Descripcion"));
        txtMResponsable.setText(getIntent().getStringExtra("Responsable"));

        txtMClave.setEnabled(false);

        btnActualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Conexion conexion = new Conexion(Actualizar.this);
                    producto producto = new producto();

                    producto.setClave(Integer.parseInt(txtMClave.getText().toString().trim()));
                    producto.setCantidad(Integer.parseInt(txtMCantidad.getText().toString().trim()));
                    producto.setPrecio(Double.parseDouble(txtMPrecio.getText().toString().trim()));
                    producto.setName(txtMName.getText().toString().trim());
                    producto.setCategoria(txtMCategoria.getText().toString().trim());
                    producto.setDescripcion(txtMDescripcion.getText().toString().trim());
                    producto.setResponsable(txtMResponsable.getText().toString().trim());

                    conexion.actualizar(producto);

                    Intent intent = new Intent(Actualizar.this, MainActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                    finish();
                } catch (NumberFormatException e) {
                    Toast.makeText(Actualizar.this,
                            "Revisa que Cantidad y Precio sean números válidos",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}