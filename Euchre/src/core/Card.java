/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import constants.Constants.Color;
import constants.Constants.Face;
import constants.Constants.Suit;

/**
 *
 * @author mauri
 */
public class Card 
{
    
    private Face face;
    private Suit suit;
    private Color color;

    
    //check if equals

    /**
     *
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj)
    {
        //System.out.println("In equals");
        if (obj instanceof Card) 
        {
            Card card = (Card) obj;
            return (card.face.equals(this.face)
                    && card.color.equals(this.color) 
                    && card.suit.equals(this.suit));
        } 
        else 
            return false;
    }

    
    //hashcode function

    /**
     *
     * @return
     */
    @Override
    public int hashCode()
    {
        //System.out.println("In hashcode");
        int hashcode = 0;
        hashcode += face.hashCode();
        hashcode += suit.hashCode();
        hashcode += color.hashCode();
        return hashcode;
    }
    
    /**
     * @return the face
     */
    public Face getFace() {
        return face;
    }

    /**
     * @param face the face to set
     */
    public void setFace(Face face) {
        this.face = face;
    }

    /**
     * @return the suit
     */
    public Suit getSuit() {
        return suit;
    }

    /**
     * @param suit the suit to set
     */
    public void setSuit(Suit suit) {
        this.suit = suit;
    }

    /**
     * @return the color
     */
    public Color getColor() {
        return color;
    }

    /**
     * @param color the color to set
     */
    public void setColor(Color color) {
        this.color = color;
    }
    
}
