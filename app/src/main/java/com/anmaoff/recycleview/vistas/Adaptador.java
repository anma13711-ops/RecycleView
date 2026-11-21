package com.anmaoff.recycleview.vistas;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.anmaoff.recycleview.Actualizar;
import com.anmaoff.recycleview.R;

import java.util.ArrayList;
import java.util.List;

public class Adaptador extends RecyclerView.Adapter<Adaptador.Vista> {

    public Context context;
    private List<String> nombre;
    private List<String> telefonos;
    int[] imagenes;
    private ArrayList<String> Clave;
    private ArrayList<String> Name;
    private ArrayList<String> Cantidad;
    private ArrayList<String> Precio;
    private ArrayList<String> Categoria;
    private ArrayList<String> Descripcion;
    private ArrayList<String> Responsable;

    public Adaptador(Context context, List<String> nombre, List<String> telefonos, int[] imagenes,
                     ArrayList<String> Clave, ArrayList<String> Name, ArrayList<String> Cantidad,
                     ArrayList<String> Precio, ArrayList<String> Categoria,
                     ArrayList<String> Descripcion, ArrayList<String> Responsable) {
        this.context = context;
        this.nombre = nombre;
        this.telefonos = telefonos;
        this.imagenes = imagenes;
        this.Clave = Clave;
        this.Name = Name;
        this.Cantidad = Cantidad;
        this.Precio = Precio;
        this.Categoria = Categoria;
        this.Descripcion = Descripcion;
        this.Responsable = Responsable;
    }

    @NonNull
    @Override
    public Adaptador.Vista onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View v = inflater.inflate(R.layout.elemento, parent, false);
        return new Vista(v);
    }

    @Override
    public void onBindViewHolder(@NonNull Adaptador.Vista holder, int position) {
        holder.txtNombre.setText(nombre.get(position));
        holder.txtTelefono.setText(telefonos.get(position));
        holder.imgfoto.setImageResource(imagenes[position % imagenes.length]);

        holder.fila.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pos = holder.getAdapterPosition();
                if (pos == RecyclerView.NO_POSITION) return;

                // Evita el cierre si la fila no tiene datos de la base de datos
                if (pos >= Clave.size()) return;

                Intent intent = new Intent(context, Actualizar.class);

                intent.putExtra("Clave", Clave.get(pos));
                intent.putExtra("Name", Name.get(pos));
                intent.putExtra("Cantidad", Cantidad.get(pos));
                intent.putExtra("Precio", Precio.get(pos));
                intent.putExtra("Categoria", Categoria.get(pos));
                intent.putExtra("Descripcion", Descripcion.get(pos));
                intent.putExtra("Responsable", Responsable.get(pos));

                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return nombre.size();
    }

    public class Vista extends RecyclerView.ViewHolder {

        TextView txtNombre, txtTelefono;
        ImageView imgfoto;
        ConstraintLayout fila;

        public Vista(@NonNull View itemView) {
            super(itemView);

            txtNombre = itemView.findViewById(R.id.txtNombre);
            txtTelefono = itemView.findViewById(R.id.txtTelefono);
            imgfoto = itemView.findViewById(R.id.imgfoto);
            fila = itemView.findViewById(R.id.fila);
        }
    }
}