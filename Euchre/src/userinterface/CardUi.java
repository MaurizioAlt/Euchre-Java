/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface;

import constants.Constants.Face;
import constants.Constants.Suit;
import core.Card;
import java.awt.Image;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;

/**
 *
 * @author mauri
 */
public class CardUi
{
    private Card card;
    private ImageIcon imageIcon;
    private JButton button;
    private JLabel label;
    private int position;
    
    public CardUi(Card card, JButton button)
    {
        this.card = card;
        this.button = button;
        
        selectFrontImage(this.button);
    }
    
    public CardUi(Card card, JLabel label, int position)
    {
        this.card = card;
        this.label = label;
        this.position = position;
        
        if(position == 2)// || position == 3)
            selectHorizontalBackImage();
        else if(position == 1 || position == 3)
            selectVerticalBackImage();
    }
    
    public CardUi(JLabel label)
    {
        this.label = label;
        
        selectHorizontalBackImage();
    }
    
    public CardUi(JLabel label, Face face, Suit suit)
    {
        this.label = label;
        Card card = new Card();
        card.setFace(face);
        card.setSuit(suit);
        this.card = card;
        selectFrontImage(label);
    }
    
    private void selectFrontImage(JComponent component)
    {
        String filename = "../images/";
        
        switch(getCard().getFace())
        {
            case ACE:
                filename += "Ace";
                break;
            case NINE:
                filename += "Nine";
                break;
            case TEN:
                filename += "Ten";
                break;
            case JACK:
                filename += "Jack";
                break;    
            case QUEEN:
                filename += "Queen";
                break;
            case KING:
                filename += "King";
                break;
        }
        
        switch(getCard().getSuit())
        {
            case CLUBS:
                filename += "Clubs";
                break;
            case HEARTS:
                filename += "Hearts";
                break;
            case DIAMONDS:
                filename += "Diamonds";
                break;
            case SPADES:
                filename += "Spades";
                break;
        }
        
        filename += ".png";
        
        try
        {
            URL imgURL = getClass().getResource(filename);
            
            if(imgURL != null)
            {
                setImageIcon(new ImageIcon(imgURL));
                setImageIcon(imageResizeHorizontal(getImageIcon()));
            }
            
            if(component instanceof JLabel)
                label = new JLabel(imageIcon);
            else
                button = new JButton(imageIcon);
        }
        catch(Exception ex)
        {
            System.err.println("Couldn't find file: " + filename);
            setImageIcon(null);
        }
    }
    
    private void selectVerticalBackImage()
    {
        String filename = "../images/backVertical.png";
        
        try
        {
            URL imgURL = getClass().getResource(filename);
            
            if(imgURL != null)
            {
                setImageIcon(new ImageIcon(imgURL));
                setImageIcon(imageResizeVertical(getImageIcon()));
                setLabel(new JLabel(getImageIcon()));
            }
            
            //if(component instanceof JLabel)
            //    label = new JLabel(imageIcon);
            //else
            //    button = new JButton(imageIcon);
        }
        catch(Exception ex)
        {
            System.err.println("Couldn't find file: " + filename);
            setImageIcon(null);
        }
    }
    
    private void selectHorizontalBackImage()
    {
        String filename = "../images/backHorizontal.png";
        
        try
        {
            URL imgURL = getClass().getResource(filename);
            
            if(imgURL != null)
            {
                setImageIcon(new ImageIcon(imgURL));
                setImageIcon(imageResizeHorizontal(getImageIcon()));
                setLabel(new JLabel(getImageIcon()));
            }
            
            //if(component instanceof JLabel)
            //    label = new JLabel(imageIcon);
            //else
            //   button = new JButton(imageIcon);
        }
        catch(Exception ex)
        {
            System.err.println("Couldn't find file: " + filename);
            setImageIcon(null);
        }
    }
    
    private ImageIcon imageResizeHorizontal(ImageIcon icon)
    {
        Image image = icon.getImage();
        Image newImage = 
                image.getScaledInstance(70, 100, java.awt.Image.SCALE_SMOOTH);
        icon = new ImageIcon(newImage);
        return icon;
    }
    
    private ImageIcon imageResizeVertical(ImageIcon icon)
    {
        Image image = icon.getImage();
        Image newImage = 
                image.getScaledInstance(100, 70, java.awt.Image.SCALE_SMOOTH);
        icon = new ImageIcon(newImage);
        return icon;
    }

    /**
     * @return the card
     */
    public Card getCard() {
        return card;
    }

    /**
     * @param card the card to set
     */
    public void setCard(Card card) {
        this.card = card;
    }

    /**
     * @return the imageIcon
     */
    public ImageIcon getImageIcon() {
        return imageIcon;
    }

    /**
     * @param imageIcon the imageIcon to set
     */
    public void setImageIcon(ImageIcon imageIcon) {
        this.imageIcon = imageIcon;
    }

    /**
     * @return the button
     */
    public JButton getButton() {
        return button;
    }

    /**
     * @param button the button to set
     */
    public void setButton(JButton button) {
        this.button = button;
    }

    /**
     * @return the label
     */
    public JLabel getLabel() {
        return label;
    }

    /**
     * @param label the label to set
     */
    public void setLabel(JLabel label) {
        this.label = label;
    }

    /**
     * @return the position
     */
    public int getPosition() {
        return position;
    }

    /**
     * @param position the position to set
     */
    public void setPosition(int position) {
        this.position = position;
    }
    
}
