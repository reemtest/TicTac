/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Player;

/**
 *
 * @author 20115
 */
public class GameController {
    
    private static GameController instance;
    
    private Player CurrentPlayer;

        
        
          
       private GameController() {
         CurrentPlayer = Player.O; //initizlizing the player of O
       }
       
    
    
   
    public Player getCurrentPlayer() {
        return CurrentPlayer;
    }
    
    // swithc players turn after each click
   public void SwitchPlayersTurns()
   {
            CurrentPlayer = (CurrentPlayer == Player.X) ? Player.O : Player.X;
   
   }
   
   
   public static synchronized GameController getInstance() { // synchronized as this is not thread safe 
      
        if (instance == null) {
            instance = new GameController();
        }
        return instance;
    }
}
