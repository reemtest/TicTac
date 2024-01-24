/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import View.Context;
import View.EmptyState;
import View.OState;
import View.State;
import View.TicTacToeView;
import View.XState;
import javax.swing.JOptionPane;

/**
 *
 * @author 20115
 */
public class GameStatus {
    
    public static void handleMoveResult(char result, TicTacToeView view, char[][] board) {
        Context c=new Context();
        State x=new XState();
        State o=new OState();
        State empty=new EmptyState();
        
        if (result == 'X') {
            //showResultMessage(view, "Player X wins!");
            c.setState(x);
            c.Symbolizing();
        } else if (result == 'O') {
           // showResultMessage(view, "Player O wins!");
            c.setState(o);
            c.Symbolizing();
        } else if (result == ' ' && isBoardFull(board)) {
            c.setState(empty);
            c.Symbolizing();
               // showResultMessage(view, "It's a draw!");
            
        }
    }
    
    private static boolean isBoardFull(char [][] Board)
    {
        for (int i=0; i<3;i++){
            for (int j=0;j<3;j++){
        if(Board [i][j] == ' ')
        {
            return false;
        }
                
            }               
                }
        return true;
        }
    
    
        private static void showResultMessage(TicTacToeView view, String message) {
        JOptionPane.showMessageDialog(view, message);
    }

   
    
    
}
