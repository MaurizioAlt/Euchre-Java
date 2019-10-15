/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package euchre;

import core.Game;
import javax.swing.JOptionPane;
import userinterface.GameUi;

/**
 *
 * @author mauri
 */
public class Euchre 
{

    /**
     *
     * @param args
     */
    public static void main(String[] args) 
    {
        // TODO code application logic here
        System.out.println("Welcome to Euchre!");
        JOptionPane.showMessageDialog(null, "Let's Play Euchre!");
        Game game = new Game();
        
        GameUi gameUi = new GameUi(game);
    }
    
}
