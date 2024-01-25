
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


package View;

/**
 *
 * @author 20115
 */
import Controller.GameController;
import Controller.GameStatus;
import Controller.Observer;
import Model.Model;
import Model.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.Random;
import javax.imageio.ImageIO;

public class TicTacToeView extends JFrame implements Observer {

    private JButton[][] buttons;
    private Player player1Symbol;
    private Player player2Symbol;
    private int gameMode; // 1 for single player, 2 for two players

    public TicTacToeView(int gameMode) {
        super("Tic Tac Toe");
        this.gameMode = gameMode;

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        setLocationRelativeTo(null);

        initializeButtons();
        initializePlayerSymbols();

        setLayout(new GridLayout(3, 3));

        // Add buttons to the JFrame
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                add(buttons[i][j]);
            }
        }

        setVisible(true);
    }

private void initializePlayerSymbols() {
    String[] options = {"X", "O"};

    int player1Choice = JOptionPane.showOptionDialog(
            this,
            "Player 1, choose your symbol:",
            "Symbol Selection",
            JOptionPane.DEFAULT_OPTION,
            JOptionPane.QUESTION_MESSAGE,
            null,
            options,
            options[0]
    );

    // Assign the opposite symbol to player 2
    player1Symbol = (player1Choice == 0) ? Player.X : Player.O;
    player2Symbol = (player1Choice == 0) ? Player.O : Player.X;
}



    private void initializeButtons() {
        buttons = new JButton[3][3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j] = new JButton("");
                buttons[i][j].setPreferredSize(new Dimension(150, 150));
                buttons[i][j].setHorizontalTextPosition(JButton.CENTER);
                buttons[i][j].setVerticalTextPosition(JButton.CENTER);
                buttons[i][j].setBorderPainted(true);
                buttons[i][j].addActionListener(new ButtonClickListener(i, j));
            }
        }
    }

    private void computerMove() {
        Random random = new Random();
        int computerRow;
        int computerCol;

        do {
            computerRow = random.nextInt(3);
            computerCol = random.nextInt(3);
        } while (Model.getInstance().getBoard()[computerRow][computerCol] != ' ');

        char computerSymbol = player2Symbol.getSymbol();
        updateButton(computerRow, computerCol, computerSymbol);

        Model.getInstance().playTwoPlayers(computerRow, computerCol, computerSymbol);
        GameController.getInstance().SwitchPlayersTurns();

        char result = Model.getInstance().checkForWinner();
        char[][] board = Model.getInstance().getBoard();
        GameStatus gameStatus = new GameStatus();
        gameStatus.handleMoveResult(result, null, board);
    }

    private void updateButton(int row, int col, char symbol) {
        String imagePath = (symbol == 'X') ? "X.png" : "O.png";

        try {
            URL imageUrl = getClass().getResource(imagePath);
            if (imageUrl != null) {
                BufferedImage image = ImageIO.read(imageUrl);
                Image scaledImage = image.getScaledInstance(
                        buttons[row][col].getWidth(),
                        buttons[row][col].getHeight(),
                        Image.SCALE_SMOOTH
                );

                buttons[row][col].setIcon(new ImageIcon(scaledImage));
                buttons[row][col].setEnabled(false);
            } else {
                System.err.println("Image not found: " + imagePath);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void update(char result, char[][] board) {
        if (result == 'X') {
            System.out.println("Player X wins!");
        } else if (result == 'O') {
            System.out.println("Player O wins!");
        } else if (result == ' ' && GameStatus.isBoardFull(board)) {
            System.out.println("It's a draw!");
        }
    }

   private class ButtonClickListener implements ActionListener {
    private int row;
    private int col;

    public ButtonClickListener(int row, int col) {
        this.row = row;
        this.col = col;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Player currentPlayer = GameController.getInstance().getCurrentPlayer();
        
        // Initialize player symbols if not already initialized
        if (player1Symbol == null || player2Symbol == null) {
            initializePlayerSymbols();
        }

        char symbol = (currentPlayer == Player.X) ? player1Symbol.getSymbol() : player2Symbol.getSymbol();
        updateButton(row, col, symbol);

        Model.getInstance().playTwoPlayers(row, col, symbol);
        GameController.getInstance().SwitchPlayersTurns();

        char result = Model.getInstance().checkForWinner();
        char[][] board = Model.getInstance().getBoard();
        GameStatus gameStatus = new GameStatus();
        gameStatus.handleMoveResult(result, null, board);

        if (gameMode == 1 && GameController.getInstance().getCurrentPlayer() == Player.O) {
            computerMove();
        }
    }
}

}
