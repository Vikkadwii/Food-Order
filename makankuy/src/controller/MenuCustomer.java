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
public class MenuCustomer {
    
    Database db = new Database();
    Restaurant view;
    private static Connection k;
    
    public MenuCustomer(Restaurant menu){
        view = menu;
    }
}
