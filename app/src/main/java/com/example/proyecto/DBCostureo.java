package com.example.proyecto;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBCostureo extends SQLiteOpenHelper {
    public static final int VERSION_DB = 3;
    public static final String NOMBRE_DB = "costureo.db";

    public static final String TAB_CLIENT = "cliente";
    public static final String COL_CLIENT_ID = "id";
    public static final String COL_CLIENT_NAME = "name";
    public static final String COL_CLIENT_EMAIL = "email";
    public static final String COL_CLIENT_TEL = "phone";
    private final String CREATE_TABLE_CLIENT = "create table " + TAB_CLIENT +
            "("
            + COL_CLIENT_ID + " integer primary key, "
            + COL_CLIENT_NAME + " text not null, "
            + COL_CLIENT_EMAIL + " text, "
            + COL_CLIENT_TEL + "integer)";

    public static final String TAB_MEASUREMENTS = "measurements";
    public static final String COL_MEASUREMENTS_ID = "id";
    public static final String COL_MEASUREMENTS_CCUELLO = "cCuello";
    public static final String COL_MEASUREMENTS_AESPALDA = "eEspalda";
    public static final String COL_MEASUREMENTS_LHOMBRO = "lHombro";
    public static final String COL_MEASUREMENTS_LMANGA = "lManga";
    public static final String COL_MEASUREMENTS_LPECHO = "lPecho";
    public static final String COL_MEASUREMENTS_LTALLED = "lTalleD";
    public static final String COL_MEASUREMENTS_LTALLET = "lTalleT";
    public static final String COL_MEASUREMENTS_CPECHO = "cPecho";
    public static final String COL_MEASUREMENTS_CPECHOBAJO = "cPechoBajo";
    public static final String COL_MEASUREMENTS_CSISA = "cSisa";
    public static final String COL_MEASUREMENTS_LPANTALON = "lPantalon";
    public static final String COL_MEASUREMENTS_CCINTURA = "cCintura";
    public static final String COL_MEASUREMENTS_LTIRO = "lTiro";
    public static final String COL_MEASUREMENTS_LCADERA = "lCadera";
    public static final String COL_MEASUREMENTS_CCADERA = "cCadera";
    public static final String COL_MEASUREMENTS_LPIERNAI = "lPiernaI";
    public static final String COL_MEASUREMENTS_CMUSLO = "cMuslo";
    public static final String COL_MEASUREMENTS_LRODILLA = "lRodilla";
    public static final String COL_MEASUREMENTS_CRODILLA = "cRodilla";
    public static final String COL_MEASUREMENTS_CPANTORRILLA = "cPantorrilla";
    public static final String COL_MEASUREMENTS_CTOBILLO = "cTobillo";
    private final String CREATE_TABLE_MEASUREMENTS = "create table " + TAB_MEASUREMENTS + "("
            + COL_MEASUREMENTS_ID + " integer primary key, "
            + COL_MEASUREMENTS_CCUELLO + " real, "
            + COL_MEASUREMENTS_AESPALDA + " real, "
            + COL_MEASUREMENTS_LHOMBRO + " real, "
            + COL_MEASUREMENTS_LMANGA + " real, "
            + COL_MEASUREMENTS_LPECHO + " real, "
            + COL_MEASUREMENTS_LTALLED + " real, "
            + COL_MEASUREMENTS_LTALLET + " real, "
            + COL_MEASUREMENTS_CPECHO + " real, "
            + COL_MEASUREMENTS_CPECHOBAJO + " real, "
            + COL_MEASUREMENTS_CSISA + " real, "
            + COL_MEASUREMENTS_LPANTALON + " real, "
            + COL_MEASUREMENTS_CCINTURA + " real, "
            + COL_MEASUREMENTS_LTIRO + " real, "
            + COL_MEASUREMENTS_LCADERA + " real, "
            + COL_MEASUREMENTS_CCADERA + " real, "
            + COL_MEASUREMENTS_LPIERNAI + " real, "
            + COL_MEASUREMENTS_CMUSLO + " real, "
            + COL_MEASUREMENTS_LRODILLA + " real, "
            + COL_MEASUREMENTS_CRODILLA + " real, "
            + COL_MEASUREMENTS_CPANTORRILLA + " real, "
            + COL_MEASUREMENTS_CTOBILLO + " real, "
            + "FOREIGN KEY (" + COL_MEASUREMENTS_ID + ") REFERENCES " + TAB_CLIENT +
            "(" + COL_CLIENT_ID + "))";

    public static final String TAB_PEDIDO = "pedido";
    public static final String COL_PEDIDO_ID = "id";
    public static final String COL_PEDIDO_CLIENT_ID = "client_id";
    public static final String COL_PEDIDO_NAME = "name";
    public static final String COL_PEDIDO_DATE = "date";
    public static final String COL_PEDIDO_INFO = "info";
    private final String CREATE_TABLE_PEDIDO = "create table " + TAB_PEDIDO +
            "("
            + COL_PEDIDO_ID + " integer primary key, "
            + COL_PEDIDO_CLIENT_ID + " integer primary key, "
            + COL_PEDIDO_NAME + " text not null, "
            + COL_PEDIDO_DATE + " text, "
            + COL_PEDIDO_INFO + "text, "
            + "FOREIGN KEY (" + COL_PEDIDO_CLIENT_ID + ") REFERENCES " + TAB_CLIENT +
            "(" + COL_CLIENT_ID + "))";

    public DBCostureo(Context context) {
        super(context, NOMBRE_DB, null, VERSION_DB);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_CLIENT);
        Log.i("Costureo", CREATE_TABLE_MEASUREMENTS);
        db.execSQL(CREATE_TABLE_MEASUREMENTS);
        Log.i("Costureo", CREATE_TABLE_PEDIDO);
        db.execSQL(CREATE_TABLE_PEDIDO);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(DBCostureo.class.getName(),
                "Upgrading database from version " + oldVersion + " to "
                        + newVersion + ", which will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS " + TAB_CLIENT);
        db.execSQL("DROP TABLE IF EXISTS " + TAB_MEASUREMENTS);
        db.execSQL("DROP TABLE IF EXISTS " + TAB_PEDIDO);
        onCreate(db);
    }
}
