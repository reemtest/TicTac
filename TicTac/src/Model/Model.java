/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.Scanner;

/**
 *
 * @author 20115
 */
public class Model {
    
private char [][] Board;

public Model()
        {
            Board= new char [3][3];
            initializeBoard();
        }

   private void initializeBoard() {
        // Initialize the board with empty spaces
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                Board[i][j] = ' ';
            }
        }
    }
  
    public void playTwoPlayers()
    {   
         
        
    }
    
   /* public void playWithComputer()
    {
    
    
    
    }
    */
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
