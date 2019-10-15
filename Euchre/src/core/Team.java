/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import java.util.ArrayList;


/**
 *
 * @author mauri
 */

public class Team 
{
    
    private ArrayList<Player> team;
    private int teamScore;
    private int teamTricks;
    private String teamName; 
    
    /**
     *
     * create teams 
     */
    public Team()
    {
        team = new ArrayList();
    }
    
    /**
     *
     * output team and players
     */
    public void outputTeams()
    {
        System.out.println(teamName + " includes players: ");
        
        for(Player player : team)
        {
            System.out.println(player.getName());
        }
    
    }
    
    /**
     *
     * output hands of players
     */
    public void outputHands()
    {
        System.out.println("*********************************");
        System.out.println("        " + teamName.toUpperCase());
        System.out.println("*********************************");
        
        for(Player player : team)
        {
            player.sortBySuit();
            
            if(player instanceof HumanPlayer)
                player.displayHand();
        }
    }

    /**
     *
     * @return
     */
    public ArrayList<Player> getTeam() {
        return team;
    }

    /**
     *
     * @param team
     */
    public void setTeam(ArrayList<Player> team) {
        this.team = team;
    }

    /**
     *
     * @return
     */
    public int getTeamScore() {
        return teamScore;
    }

    /**
     *
     * @param teamScore
     */
    public void setTeamScore(int teamScore) {
        this.teamScore = teamScore;
    }

    /**
     *
     * @return
     */
    public int getTeamTricks() {
        return teamTricks;
    }

    /**
     *
     * @param teamTricks
     */
    public void setTeamTricks(int teamTricks) {
        this.teamTricks = teamTricks;
    }

    /**
     *
     * @return
     */
    public String getTeamName() {
        return teamName;
    }

    /**
     *
     * @param teamName
     */
    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }   
}
