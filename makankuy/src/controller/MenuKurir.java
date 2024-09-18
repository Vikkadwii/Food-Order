/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Model.Database;
import Model.Pesanan;
import Model.Restoran;
import Model.Kurir;
import View.Restaurant;
import View.Kurirr;
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
public class MenuKurir {
   Kurirr kr;
   Database db = new Database();
   
   
    public void tampilPesanan(){
        ArrayList<Pesanan> ps = db.getPesan();
        DefaultTableModel model = kr.getTable();
        
        for(Pesanan p:ps){
            Object O []={ p.getNama(), p.getAlamat(), p.getPesanan(), p.getHarga(),  p.getJumlahpesanan(),p.totharga(),p.getNo_hp()};
            model.addRow(O);
        }
        kr.setTable(model);
    }
    
    public MenuKurir(Kurirr K){
            kr = K;
            tampilPesanan();
            kr.buttonSelesai(new ButtonSelesai());

    }
    
    class ButtonSelesai implements ActionListener{


        @Override
        public void actionPerformed(ActionEvent e) {
            int row = kr.getTablePesanan().getSelectedRow();
            if (row >= 0){
                DefaultTableModel model = (DefaultTableModel) kr.getTablePesanan().getModel();
                model.removeRow(row);
            }

        }
        
        
    }
}
