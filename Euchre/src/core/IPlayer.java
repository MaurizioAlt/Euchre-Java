/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

/**
 *
 * @author mauri
 */
public interface IPlayer 
{

    /**
     *
     * @return
     */
    public Card playCard();

    /**
     *make trump
     */
    public void makeTrump();
}
