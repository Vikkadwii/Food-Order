/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;
import View.Login_View;
import controller.Login;


/**
 *
 * @author ASUS
 */
public class Driver {
    public static void main(String[] args){
        Login_View View = new Login_View();
        Login L = new Login(View);
        View.setVisible(true);
        
       
    }
}
