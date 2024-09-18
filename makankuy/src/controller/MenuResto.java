/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Model.Database;
import Model.Pesanan;
import View.Restaurant;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ASUS
 */
public class MenuResto {
    Database db = new Database();
    Restaurant view;
    private static Connection k;
    
    public MenuResto(Restaurant menu){
        view = menu;
        tampilPesanan();
        //view.tambah(new Tambah());
        view.buttonSelesai(new ButtonSelesai());
        
    }
    public void tampilPesanan(){
        ArrayList<Pesanan> ps = db.getPesan();
        DefaultTableModel model = view.getTable();
        
        for(Pesanan p:ps){
            Object O []={ p.getNama(), p.getAlamat(), p.getPesanan(), p.getHarga(), p.getJumlahpesanan(),p.totharga()};
            model.addRow(O);
        }
        view.setTable(model);
    }
    
    class ButtonSelesai implements ActionListener{


        @Override
        public void actionPerformed(ActionEvent e) {
            int row = view.getTablePesanan().getSelectedRow();
            if (row >= 0){
                DefaultTableModel model = (DefaultTableModel) view.getTablePesanan().getModel();
                model.removeRow(row);
            }
        }
    }
    
}
