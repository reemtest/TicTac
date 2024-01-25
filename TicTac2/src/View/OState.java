/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import javax.swing.JOptionPane;

/**
 *
 * @author LENOVO
 */
public class OState implements State {
    @Override
    public void Symbolizing()
    {
      
     JOptionPane.showMessageDialog(null,"Player O wins!");
    
    }
}
