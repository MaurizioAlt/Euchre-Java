/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author mauri
 */
public abstract class Player implements IPlayer 
{
    private String name; 
    private int tricks;
    private int bid;
    private int score;
    private ArrayList<Card> hand = new ArrayList();
    
    JPanel ui;
    
    private boolean acceptTrump;

    public void setUi(JPanel ui) {
        this.ui = ui;
    }

    public JPanel getUi() {
        return ui;
    }
    
    /**
     *
     * @return
     */
    @Override
    public abstract Card playCard();

    /**
     *
     */
    @Override
    public abstract void makeTrump();
    
    /**
     *
     */
    public void displayHand()
    {
        //createArray();
        System.out.println("*********************************");
        System.out.println("Player " + name + " hand is ");
        System.out.println("*********************************");
        
        for(Card card : hand)
        {
            System.out.println(card.getFace() + " of " + card.getSuit());
        }
    }
    
    /**
     *
     */
    public void sortBySuit()
    {
        ArrayList<Card> sortedHand = new ArrayList<Card>();
        
        while(hand.size() > 0)
        {
            int position = 0;
            Card firstCard = hand.get(0);
            
            for(int i = 0; i < hand.size(); i++)
            {
                Card nextCard = hand.get(i);
                if(
                   nextCard.getSuit().getRank() < firstCard.getSuit().getRank()
                   || 
                    (
                    nextCard.getSuit() == firstCard.getSuit() 
                    && 
                    nextCard.getFace().getValue() < firstCard.getFace().getValue()
                    )
                  )
                {
                    position = i;
                    firstCard= nextCard;
                }
            }
            
            hand.remove(position);
            sortedHand.add(firstCard);
            
        }
        
        hand = sortedHand;
        
    }
    
    /**
     *
     * @return
     */
    public ArrayList<Card> getHand() {
        return hand;
    }
    
    /**
     *
     * @param hand
     */
    public void setHand(ArrayList<Card> hand) {
        this.hand = hand;
    }

    /**
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return
     */
    public int getTricks() {
        return tricks;
    }

    /**
     *
     * @param tricks
     */
    public void setTricks(int tricks) {
        this.tricks = tricks;
    }

    /**
     *
     * @return
     */
    public int getBid() {
        return bid;
    }

    /**
     *
     * @param bid
     */
    public void setBid(int bid) {
        this.bid = bid;
    }

    /**
     *
     * @return
     */
    public int getScore() {
        return score;
    }

    /**
     *
     * @param score
     */
    public void setScore(int score) {
        this.score = score;
    }

    /**
     * @return the acceptTrump
     */
    public boolean getAcceptTrump() {
        return acceptTrump;
    }

    /**
     * @param acceptTrump the acceptTrump to set
     */
    public void setAcceptTrump(boolean acceptTrump) {
        this.acceptTrump = acceptTrump;
    }
}
