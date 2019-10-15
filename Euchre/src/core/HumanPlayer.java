/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import constants.Constants;
import java.awt.Component;
import javax.swing.JOptionPane;

/**
 *
 * @author mauri
 */
public class HumanPlayer extends Player
{
    public Game getGame() {
        return game;
    }

    /**
     * @param game the game to set
     */
    public void setGame(Game game) {
        this.game = game;
    }
    private Game game;
    /**
     *
     * @return
     */
    @Override
    public Card playCard() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     *
     */
    @Override
    public void makeTrump()
    {
        if(game.getTrumpCheck() == Constants.MAX_PASSES)
        {
            JOptionPane.showMessageDialog(null, "Sorry Dealer, you have to accept Trump!");
            setAcceptTrump(true);
        }
        else
        {
            int response = JOptionPane.showConfirmDialog(null, "Do you accept the trump?");
                                                        //humanUi
            if(response == JOptionPane.YES_OPTION)
                setAcceptTrump(true);
            else
                setAcceptTrump(false);
        }
    }
    
}
