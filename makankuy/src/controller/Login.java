/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import Model.Database;
import View.Admin;
import View.Kurirr;
import View.Login_View;
import View.Restaurant;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import View.customer;

/**
 *
 * @author ASUS
 */
public class Login {
    Login_View LV;
    Database DB = new Database();
    public Login(Login_View View){
        DB.connect();
        LV = View;
        LV.btnAdmin(new ButtonAdmin());
        LV.btnKurir(new ButtonKurir());
        LV.btnCustomer(new ButtonCustomer());
        LV.btnRestaurant(new ButtonRestaurant());
    }
    
    class ButtonAdmin implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            String username= LV.getUsername();
            String password = LV.getPassword();
            String query = "SELECT *FROM admin WHERE username = '"+username+"' AND password = '"+password+"'";
            try{
                Connection C = DB.connection;
                Statement S = C.createStatement();
                ResultSet RS = S.executeQuery(query);
                if(RS.next()){
                    Admin A  = new Admin();
                    MenuAdmin control = new MenuAdmin(A);
                    A.setVisible(true);
                    
                }
            } catch (Exception E){
                
            }
        }
        
    }  
    
    class ButtonRestaurant implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            String username= LV.getUsername();
            String password = LV.getPassword();
            String query = "SELECT *FROM restaurent WHERE username = '"+username+"' AND password = '"+password+"'";
            try{
                Connection C = DB.connection;
                Statement S = C.createStatement();
                ResultSet RS = S.executeQuery(query);
                if(RS.next()){
                    Restaurant A  = new Restaurant();
                    MenuResto control = new MenuResto(A);
                    A.setVisible(true);
                    
                }
            } catch (Exception E){
                
            }
        }
    }
    
    class ButtonKurir implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            String username= LV.getUsername();
            String password = LV.getPassword();
            String query = "SELECT *FROM kurir WHERE username = '"+username+"' AND password = '"+password+"'";
            try{
                Connection C = DB.connection;
                Statement S = C.createStatement();
                ResultSet RS = S.executeQuery(query);
                if(RS.next()){
                    Kurirr K  = new Kurirr();
                    MenuKurir control = new MenuKurir(K);
                    K.setVisible(true);
                    
                }
            } catch (Exception E){
                
            }
    }
    }
    
    class ButtonCustomer implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            String username= LV.getUsername();
            String password = LV.getPassword();
            String query = "SELECT *FROM user WHERE username = '"+username+"' AND password = '"+password+"'";
            try{
                Connection C = DB.connection;
                Statement S = C.createStatement();
                ResultSet RS = S.executeQuery(query);
                if(RS.next()){
                    customer CUST  = new customer();
                    CUST.setVisible(true);
                    
                }
            } catch (Exception E){
                
            }
        }
        
    }
}
        
