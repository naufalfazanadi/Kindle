package edu.upi.mobprogproject.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import edu.upi.mobprogproject.model.Users;

/**
 * Created by amaceh on 11/11/17.
 */

public class DbUsers {
    private SQLiteDatabase db;
    private final DbHelper dbHelper;

    public DbUsers(Context c) {
        dbHelper =  new DbHelper(c);
    }

    public void open() {
        db = dbHelper.getWritableDatabase();
    }

    public void close() {
        db.close();
    }

    public long insertUser(Users k){
        ContentValues newV = new ContentValues();
        newV.put("username", k.getUsername());
        newV.put("email", k.getEmail());
        newV.put("password", k.getPassword());
        newV.put("nama", k.getNama());

        return db.insert("users", null, newV);
    }

    public Users getUser(String user, String password){
        Cursor cur = null;
        Users K = new Users();

        //kolom yang diambil
        String[] cols = new String [] {"id", "username", "nama"};
        //parameter, akan mengganti ? pada NAMA=?
        String[] param  = {user, password,user, password};

        cur = db.query("users",cols,"username=? AND password=? OR email=? AND password=?",param,null,null,null);

        if (cur.getCount()>0) {  //ada data? ambil
            cur.moveToFirst();
            K.setId(cur.getInt(0));
            K.setUsername(cur.getString(1));
            K.setNama(cur.getString(2));
        }
        cur.close();
        return K;
    }

    public Users getUserData(String user){
        Cursor cur = null;
        Users K = new Users();

        /*
            username, email, password, nama,
            alamat, no_telp, status, nik, pekerjaan,
             lokasi_lat, lokasi_lon
         */
        //kolom yang diambil
        String[] cols = new String [] {"id", "username", "nama", "email", "alamat",
                "no_telp", "status", "nik", "pekerjaan"};
        //parameter, akan mengganti ? pada NAMA=?
        String[] param  = {user, user};
        cur = db.query("users",cols,"username=? OR email=?",param,null,null,null);

        if (cur.getCount()>0) {  //ada data? ambil
            cur.moveToFirst();
            K.setId(cur.getInt(0));
            K.setUsername(cur.getString(1));
            K.setNama(cur.getString(2));
            K.setEmail(cur.getString(3));
            K.setAlamat(cur.getString(4));
            K.setNo_telp(cur.getString(5));
            K.setStatus(cur.getString(6));
            K.setPekerjaan(cur.getString(7));
        }
        cur.close();
        return K;
    }

}
