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
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author 20115
 */
public class GameStatus implements Subject  {

    private List<Observer> observers = new ArrayList<>();
    public void handleMoveResult(char result, TicTacToeView view, char[][] board) {
       
        Context c=new Context();
        State x=new XState();
        State o=new OState();
        State empty=new EmptyState();
        
        if (result == 'X') {
            c.setState(x);
            c.Symbolizing();
            notifyObservers(result, board);
           
           // showResultMessage(view, "Player X wins!");
        } else if (result == 'O') {
            c.setState(o);
            c.Symbolizing();
            notifyObservers(result, board);
            //showResultMessage(view, "Player O wins!");
        } else if (result == ' ' && isBoardFull(board)) {
            c.setState(empty);
            c.Symbolizing();
            notifyObservers(result, board);
            // showResultMessage(view, "It's a draw!");
            
        }


    }
    
    public static boolean isBoardFull(char[][] Board)
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

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public  void notifyObservers(char result, char[][] board) {
        for (Observer observer : observers) {
            observer.update(result, board);
        }
    }

//        private static void showResultMessage(TicTacToeView view, String message) {
//        JOptionPane.showMessageDialog(view, message);
//    }

    
   
   
    
    }

    
    
    

