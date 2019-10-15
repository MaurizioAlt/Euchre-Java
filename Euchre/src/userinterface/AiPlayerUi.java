/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface;

import constants.Constants;
import core.AiPlayer;
import core.Player;
import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author mauri
 */
public class AiPlayerUi extends JPanel
{
    private AiPlayer ai;
    private int position;
    private ArrayList<JLabel> cards;
    
    private CardUi cardUi;
    private GameUi gameUi;
    private int width;
    private int height;
    
    /**
     *
     * @param player
     * @param position
     */
    public AiPlayerUi(Player player, int position, GameUi gameUi)
    {
        ai = (AiPlayer)player;
        ai.setUi(this);
        
        this.position = position;
        this.gameUi = gameUi;
        
        initComponents();
    }

    private void initComponents()
    {
        this.setBorder(BorderFactory.createTitledBorder(ai.getName()));
        this.setMinimumSize(new Dimension(200, 250));
        this.setPreferredSize(new Dimension(200, 250));
        
        cards = new ArrayList<JLabel>();
        
        if(position == 1 || position == 3)
        {
            this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
            this.width = 100;
            this.height = 50;
        }
        else
        {
            this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
            this.width = 50;
            this.height = 100;
        }
        
        displayCards();
    }

    private void displayCards()
    {
        cards = new ArrayList<JLabel>();
        
        for(int c = 0; c < Constants.CARDS_EACH; c++)
        {
            JLabel card = new JLabel();
            cardUi = new CardUi(ai.getHand().get(c), card, position);
            card = cardUi.getLabel();
            card.setMinimumSize(new Dimension(width, height));
            card.setPreferredSize(new Dimension(width, height));
            card.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            
            card.putClientProperty("position", c);
            card.putClientProperty("face", ai.getHand().get(c).getFace());
            card.putClientProperty("suit", ai.getHand().get(c).getSuit());
            
            //card.setText("CARD " + c);
            cards.add(card);
            this.add(card);
        }
    }
    
}
