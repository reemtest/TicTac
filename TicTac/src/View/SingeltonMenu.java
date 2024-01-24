/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

/**
 *
 * @author LENOVO
 */
public class SingeltonMenu {
    private  Menu menu;
    
     private static SingeltonMenu single = null;

    private SingeltonMenu() {
        this.menu = new Menu();
    }

    public synchronized static  SingeltonMenu  getInstance() {
        if (single == null) {
            single = new SingeltonMenu();
        }
        return single;
    }

     public void setIsVisible(boolean isVisible) {
     
       menu.setVisible(isVisible);
    }
   
   
    
    
    
}
