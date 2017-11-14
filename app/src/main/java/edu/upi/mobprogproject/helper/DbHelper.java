package edu.upi.mobprogproject.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by amaceh on 11/11/17.
 * A class to help connect with sqlite android
 *
 * Users Attribute
 * username, email, password, nama,
   alamat, no_telp, status, nik, pekerjaan,
   lokasi_lat, lokasi_lon
 *
 *
 *
 *
 */

public class DbHelper extends SQLiteOpenHelper {
    // Logcat tag
    private static final String LOG = "DBHelper";
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "DBKindle.db";

    // TODO table create statement
    private static final String CREATE_TABLE_USERS =
            "CREATE TABLE USERS(id INTEGER PRIMARY KEY AUTOINCREMENT, username TEXT UNIQUE NOT NULL, " +
                    "email TEXT UNIQUE NOT NULL, password TEXT NOT NULL, " +
                    "nama TEXT, alamat TEXT, no_telp TEXT, NIK TEXT, PEKERJAAN TEXT, " +
                    "lokasi_lat REAL, lokasi_lon REAL)";

    DbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //create database
        db.execSQL(CREATE_TABLE_USERS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        //jika app diupgrade (diinstall yang baru) maka database akan dicreate ulang (data hilang)
        //jika tidak tidak ingin hilang, bisa diproses disini
        db.execSQL("DROP TABLE IF EXISTS USERS");

//        db.execSQL(scriptUpdate);
//        db.needUpgrade(newVersion);

        onCreate(db);
    }
}
