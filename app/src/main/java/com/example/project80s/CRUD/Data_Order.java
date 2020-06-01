package com.example.project80s.CRUD;

public class Data_Order {
    private String paket;
    private String jenis;
    private String harga;
    private String key;

    public String getKey(){
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getPaket() {
        return paket;
    }

    public void setPaket(String paket) {
        this.paket = paket;
    }

    public String getJenis() {
        return jenis;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

    public String getHarga() {
        return harga;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }

    public Data_Order(){
    }

    //Konstruktor dengan beberapa parameter, untuk mendapatkan Input Data dari User
    public Data_Order(String paket, String jenis, String harga) {
        this.paket = paket;
        this.jenis = jenis;
        this.harga = harga;
    }

}
