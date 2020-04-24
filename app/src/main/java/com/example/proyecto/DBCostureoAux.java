package com.example.proyecto;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import org.json.JSONException;
import org.json.JSONObject;

public class DBCostureoAux {
    private static DBCostureo db;

    public DBCostureoAux(Context context) {
        db = new DBCostureo(context);
    }

    public static void guardarCliente(JSONObject jObject) {
        try {
            SQLiteDatabase query = db.getWritableDatabase();
            ContentValues contenido = new ContentValues();
            if (!codiUsuariExist(jObject.getString("codiusuari"))) {
                contenido.put(DBQuePasa.COL_USER_ID,
                        jObject.getString("codiusuari"));
                contenido.put(DBQuePasa.COL_USER_NAME,
                        jObject.getString("nom"));
                query.insert(DBQuePasa.TAB_USER, null, contenido);
            }
            contenido = new ContentValues();
            query = db.getWritableDatabase();
            contenido.put(DBQuePasa.COL_MSG_ID,
                    jObject.getString("codimissatge"));
            contenido.put(DBQuePasa.COL_MSG_MSG, jObject.getString("msg"));
            contenido.put(DBQuePasa.COL_MSG_DATE,
                    jObject.getString("datahora"));
            contenido.put(DBQuePasa.COL_MSG_ID_USER,
                    jObject.getString("codiusuari"));
            query.insert(DBQuePasa.TAB_MSG, null, contenido);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
