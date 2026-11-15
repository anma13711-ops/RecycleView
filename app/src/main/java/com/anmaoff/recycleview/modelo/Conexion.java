package com.anmaoff.recycleview.modelo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Conexion extends SQLiteOpenHelper {

    private Context context;
    private static  final String BD = "Inventario.DB";
    private static final int version = 1;

    public Conexion(@Nullable Context context) {
        super(context, BD, null, version);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String query = "CREATE TABLE registro (Clave INT PRIMARY KEY, Name TEXT, Cantidad INT, Precio DOUBLE, Categoria TEXT, Descripcion TEXT, Responsable TEXT)";
        db.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS registro");
        onCreate(db);


    }

    public void agregar(producto producto){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("Clave", producto.getClave());
        values.put("Name", producto.getName());
        values.put("Cantidad", producto.getCantidad());
        values.put("Precio", producto.getPrecio());
        values.put("Categoria", producto.getCategoria());
        values.put("Descripcion", producto.getDescripcion());
        values.put("Responsable", producto.getResponsable());

        db.insert("registro", null, values);

    }

    public Cursor consultar() {

        String query = "Select * from registro";
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;

        if (cursor == null) {
            cursor = db.rawQuery(query, null);

        }

        return cursor;

    }

}
