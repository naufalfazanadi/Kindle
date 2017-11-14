package edu.upi.mobprogproject.model;

/**
 * Created by amaceh on 11/11/17.
 * Class to model Account User in Databases
 */

public class Users {
    private int id;
    private String username, email, password, nama,
            alamat, no_telp, status, nik, pekerjaan,
            lokasi_lat, lokasi_lon;

    public Users(){

    }

    //overload for signup
    public Users(String username, String email, String password, String nama){
        this.username = username;
        this.password = password;
        this.email = email;
        this.nama = nama;
    }

    //overload to all (if required tho)
    public Users(String username, String email, String password, String nama,
                 String alamat, String no_telp, String status, String nik, String pekerjaan){
        this.username = username;
        this.password = password;
        this.email = email;
        this.nama = nama;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getNo_telp() {
        return no_telp;
    }

    public void setNo_telp(String no_telp) {
        this.no_telp = no_telp;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNik() {
        return nik;
    }

    public void setNik(String nik) {
        this.nik = nik;
    }

    public String getPekerjaan() {
        return pekerjaan;
    }

    public void setPekerjaan(String pekerjaan) {
        this.pekerjaan = pekerjaan;
    }

    public String getLokasi_lat() {
        return lokasi_lat;
    }

    public void setLokasi_lat(String lokasi_lat) {
        this.lokasi_lat = lokasi_lat;
    }

    public String getLokasi_lon() {
        return lokasi_lon;
    }

    public void setLokasi_lon(String lokasi_lon) {
        this.lokasi_lon = lokasi_lon;
    }
}
