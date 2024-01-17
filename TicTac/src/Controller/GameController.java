/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

/**
 *
 * @author 20115
 */
public class GameController {
        private static GameController instance;

        
          
       private GameController() {
           // private to prevent instatiation 
    }
       
       
   public static synchronized GameController getInstance() { // synchronized as this is not thread safe 
      
        if (instance == null) {
            instance = new GameController();
        }
        return instance;
    }
}
