/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 *
 * @author ASUS
 */
public class DBconn {
    static Connection con;
    static Statement stt;
    public static Connection getConnection(){
        if(con == null){
            try{
                con = DriverManager.getConnection("jdbc:mysql://localhost/db_makankuy", "root", "");
            }
            catch(Exception e){
                System.out.println(e.getMessage());
            }
        }
        return con;
    }
    public static Statement getStatement(){
        if(stt == null){
            try{
                stt = con.createStatement();
            }
            catch(Exception e){
                System.out.println(e.getMessage());
            }
        }
        return stt;
    }
}
