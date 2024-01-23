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
import Model.Player;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;

public class TicTacToeView extends JFrame {
    private JButton[][] buttons;
    public TicTacToeView() {
        // Set up the JFrame
        super("Tic Tac Toe");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        setLocationRelativeTo(null);

        // Initialize the buttons
        buttons = new JButton[3][3];
        initializeButtons();

        // Set layout manager
        setLayout(new GridLayout(3, 3));

        // Add buttons to the JFrame
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                add(buttons[i][j]);
            }
        }

        setVisible(true);
    }

    private void initializeButtons() {
        // Create buttons and set ActionListener
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j] = new JButton("");
                buttons[i][j].setPreferredSize(new Dimension(150, 150)); // Set preferred size for the button

                // Customize layout to center the image in the button
                buttons[i][j].setHorizontalTextPosition(JButton.CENTER);
                buttons[i][j].setVerticalTextPosition(JButton.CENTER);
                buttons[i][j].setBorderPainted(true);

                buttons[i][j].addActionListener(new ButtonClickListener(i, j));
            }
        }
    }
    
    

    public void updateButton(int row, int col, char symbol) {
        // Load and set the image based on the user's move
        String imagePath = (symbol == 'X') ? "X.png" : "O.png";// loading the image according to the update done in action performed method

        // uploading the images
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
                buttons[row][col].setEnabled(false); // Disable the button after being clicked
            } else {
                System.err.println("Image not found: " + imagePath);// if the image of the symbol wasn't uploaded correctly
            }
        } catch (IOException ex) {
            ex.printStackTrace();
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
 // Get the current player from the GameController without accessing the model directly 
        Player currentPlayer = GameController.getInstance().getCurrentPlayer(); //instantiation of the controller 

        // Update the button with the current player's symbol
        char symbol = (currentPlayer == Player.X) ? 'X' : 'O';
        updateButton(row, col, symbol);

        // Switch players' turns in the GameController without accessing the model directly 
        GameController.getInstance().SwitchPlayersTurns();        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TicTacToeView());
  }
}
