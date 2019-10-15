/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface;

import constants.Constants;
import constants.Constants.Suit;
import core.HumanPlayer;
import core.Player;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author mauri
 */
public class HumanPlayerUi extends JPanel
{
    private HumanPlayer human;
    private ArrayList<JButton> cards;
    
    private CardUi cardUi;
    private GameUi gameUi;
    private JFrame parent;
    private Suit suit;
    
    /**
     *
     * @param player
     * @param gameUi
     */
    public HumanPlayerUi(Player player, GameUi gameUi)
    {
        human = (HumanPlayer)player;
        this.gameUi = gameUi;
        
        initComponents();
    }

    private void initComponents()
    {
        this.setBorder(BorderFactory.createTitledBorder(human.getName()));
        this.setMinimumSize(new Dimension(250, 150));
        this.setPreferredSize(new Dimension(250, 150));
        
        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        
        cards = new ArrayList<JButton>();
        
        displayCards();
    }

    private void displayCards()
    {
        cards = new ArrayList<JButton>();
        
        for(int c = 0; c < Constants.CARDS_EACH; c++)
        {
            JButton card = new JButton();
            cardUi = new CardUi(human.getHand().get(c), card);
            card = cardUi.getButton();
            
            card.setMinimumSize(new Dimension(100, 30));
            card.setPreferredSize(new Dimension(100, 30));
            card.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            
            card.putClientProperty("position", c);
            card.putClientProperty("face", human.getHand().get(c).getFace());
            card.putClientProperty("suit", human.getHand().get(c).getSuit());
            
            card.addActionListener(new CardListener());
            
            //card.setText("CARD " + c);
            cards.add(card);
            this.add(card);
        }
    }

    private static final Logger LOG = Logger.getLogger(HumanPlayerUi.class.getName());

    private static class CardListener implements ActionListener {

        public CardListener() {
            
        }

        @Override
        public void actionPerformed(ActionEvent ae) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }
}
