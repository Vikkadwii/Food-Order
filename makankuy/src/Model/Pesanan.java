/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author ASUS
 */
public class Pesanan {
    private String nama, alamat, pesanan, no_hp;
    private int harga, jumlahpesanan;
    private int ID;
    
    public Pesanan(String nama, String alamat, String pesanan,int harga, int jumlahpesanan, String no_hp){
       //this.ID = ID;
        this.nama = nama;
        this.alamat = alamat;
        this.pesanan = pesanan;
        this.jumlahpesanan = jumlahpesanan;
        this.harga = harga;
        this.no_hp = no_hp;
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

    public String getPesanan() {
        return pesanan;
    }

    public void setPesanan(String pesanan) {
        this.pesanan = pesanan;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    public int getJumlahpesanan() {
        return jumlahpesanan;
    }

    public void setJumlahpesanan(int jumlahpesanan) {
        this.jumlahpesanan = jumlahpesanan;
    }

    public String getNo_hp() {
        return no_hp;
    }

    
    public void setNo_hp(String no_hp) {
        this.no_hp = no_hp;
    }
    
    public int totharga(){
        return harga = harga*jumlahpesanan;
    }
}
