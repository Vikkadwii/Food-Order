/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**
 *
 * @author ASUS
 */
public class Database {
    public Connection connection;
    private final ArrayList<Pesanan> pesanan = new ArrayList<>();
    
    public Database(){
        
    }
   
   
    public void connect() { //method untuk mengkoneksikan database 
         try{
            String url = "jdbc:mysql://localhost:3306/db_makankuy";
            String username = "root";
            String pass = "";
            connection = DriverManager.getConnection(url, username, pass);
            System.out.println("Connected to Database");    
        }
        catch (SQLException ex) {
            System.out.println("Connection Error");
            ex.printStackTrace();
        }
    }
     public void disconnect(){
        try {
            connection.close();
            Statement stmt = connection.createStatement();
              stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public boolean manipulate(String query){
        boolean cek = false;
        try {
            int row;
            Statement stmt = connection.createStatement();
            row = stmt.executeUpdate(query);
            if (row > 0) cek = true;
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return cek;
    }
    
    public boolean cekDuplikatKodePesanan(String kode){
        boolean cek = false;
        for (Pesanan b : pesanan) {
            if (b.getNama().equals(kode)) {
                cek = true;
                break;
            }
        }
        return cek;
    }
    public ArrayList<Pesanan> getPesan(){
        connect();
        String query = "SELECT * FROM pesanan";
        try{
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            ArrayList<Pesanan> ps = new ArrayList<>();
            while(rs.next()){
                Pesanan p = new Pesanan(rs.getString("Nama"),rs.getString("Alamat"),rs.getString("Pesanan"),rs.getInt("Jumlah Pesanan"),rs.getInt("Harga"),rs.getString("No_Hp"));
                ps.add(p);
            }
            return ps;
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return null;  
    }
    
    public void addPesanan(Pesanan b){
        connect();
        String query = "INSERT INTO pesanan VALUES (";
        query += "'" + b.getNama()+ "',";
        query += "'" + b.getAlamat() + "',";
        query += "'" + b.getPesanan() + "')";
        query += "'" + b.getJumlahpesanan() + "')";
        query += "'" + b.getHarga() + "')";
        query += "'" + b.getNo_hp() + "')";
        
        
        if (manipulate(query)) pesanan.add(b);
        //disconnect();
    }
    //minta tolong dibikinkan database dan login
    //minta dibenerin
    public void delPesanan(String kode){
        connect();
        String query = "DELETE FROM pesanan WHERE idrest='"+ kode+"';";
        if (manipulate(query)) {
            for (Pesanan b : pesanan) {
                if (b.getNama().equals(kode)) {
                    pesanan.remove(b);
                    break;
                }
            }
        }
        //disconnect();
    }
    public void updatePesanan(Pesanan b){
        connect();
        String query = "UPDATE pesanan SET";
        query += "Nama Makanan :" + b.getPesanan() + "',";
        query += "Harga :" + b.getHarga() + "')";
        
        query += "Harga" + b.getHarga() + "')";
        if (manipulate(query)) {
            for (Pesanan b1 : pesanan) {
                if (b1.getNama().equals(b.getNama())) {
                    b1.setNama(b.getNama());
                    b1.setAlamat(b.getAlamat());
                    b1.setPesanan(b.getPesanan());
                    b1.setJumlahpesanan(b.getJumlahpesanan());
                    
                    b1.setHarga(b.getHarga());
                    break;
                }
            }
        }
        query += "'" + b.getNo_hp() + "')";
    }
}
