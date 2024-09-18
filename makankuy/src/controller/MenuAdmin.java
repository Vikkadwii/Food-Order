/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

//import Model.Application;
import Model.Database;
import Model.Pesanan;
import Model.Restoran;
import View.Restaurant;
import View.Admin;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import static sun.net.www.MimeTable.loadTable;

/**
 *
 * @author ASUS
 */
public class MenuAdmin {
   Admin adm;
   Database db = new Database();
   
   
    public void tampilPesanan(){
        ArrayList<Pesanan> ps = db.getPesan();
        DefaultTableModel model = adm.getTable();
        
        for(Pesanan p:ps){
            Object O []={ p.getNama(), p.getAlamat(), p.getPesanan(), p.getHarga(),  p.getJumlahpesanan(),p.totharga()};
            model.addRow(O);
        }
        adm.setTable(model);
    }
    
    public MenuAdmin(Admin ad){
            adm = ad;
            tampilPesanan();

    }
}
