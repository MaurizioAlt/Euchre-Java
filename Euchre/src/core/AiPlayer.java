/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import constants.Constants;
import javax.swing.JOptionPane;
import userinterface.AiPlayerUi;

/**
 *
 * @author mauri
 */
public class AiPlayer extends Player
{
    
    Game game;

    public void setGame(Game game) {
        this.game = game;
    }

    public Game getGame() {
        return game;
    }

    /**
     *
     * @return
     */
    @Override
    public Card playCard()
    {
        Card card = new Card();
        
        return card;
    }

    /**
     *
     */
    @Override
    public void makeTrump()
    {
        AiPlayerUi aiUi = (AiPlayerUi)getUi();
        
        if(game.getTrumpCheck() == Constants.MAX_PASSES)
        {
            JOptionPane.showMessageDialog(aiUi, "Sorry dealer, you have to accept trump!");
            setAcceptTrump(true);
        }
        else
        {
            int trumpCount = 0;
            
            for(Card card : this.getHand())
            {
                if(card.getSuit() == game.getTrump().getSuit())
                    trumpCount++;
            }
            
            if(trumpCount >= Constants.MIN_TRUMP)
            {
                this.setAcceptTrump(true);
                JOptionPane.showMessageDialog(aiUi, (this.getName() + " says \"Pick it up!\""));
            }
            else
            {
                this.setAcceptTrump(false);
                JOptionPane.showMessageDialog(aiUi, (this.getName() + " says \"Pass!\""));
            }
        }
    }
    
}
