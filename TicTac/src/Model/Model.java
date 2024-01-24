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
        private static Model instance;

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
   
       public static synchronized Model getInstance() {
        if (instance == null) {
            instance = new Model();
        }
        return instance;
    }
       
       public char [][] getBoard()
       {
           return Board;
       }

    public void playTwoPlayers(int row, int col, char symbol) {
        // Check if the cell is empty before making a move
        if (Board[row][col] == ' ') {
            Board[row][col] = symbol;
        }
    }
  
    public char checkForWinner() {
        // Check rows
        for (int i = 0; i < 3; i++) {
            if (Board[i][0] == Board[i][1] && Board[i][1] == Board[i][2] && Board[i][0] != ' ') {
                return Board[i][0]; // Winner found in row
            }
        }

        // Check columns
        for (int j = 0; j < 3; j++) {
            if (Board[0][j] == Board[1][j] && Board[1][j] == Board[2][j] && Board[0][j] != ' ') {
                return Board[0][j]; // Winner found in column
            }
        }

        // Check diagonals
        if (Board[0][0] == Board[1][1] && Board[1][1] == Board[2][2] && Board[0][0] != ' ') {
            return Board[0][0]; // Winner found in diagonal (top-left to bottom-right)
        }
        if (Board[0][2] == Board[1][1] && Board[1][1] == Board[2][0] && Board[0][2] != ' ') {
            return Board[0][2]; // Winner found in diagonal (top-right to bottom-left)
        }

        return ' '; // No winner yet
    }
    
  /*  public void playWithComputer()
    {
    
    
    
    }
    */
    
    
    }
