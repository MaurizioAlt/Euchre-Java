/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import constants.Constants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;
import javax.swing.JOptionPane;
import userinterface.GameUi;

/**
 *
 * @author mauri
 */
public class Game {

    /**
     * @return the trumpCheck
     */
    public int getTrumpCheck() {
        return trumpCheck;
    }

    /**
     * @param trumpCheck the trumpCheck to set
     */
    public void setTrumpCheck(int trumpCheck) {
        this.trumpCheck = trumpCheck;
    }

    private Card trump;
    private Player leadPlayer;
    private Player dealer;
    private Player wonTrick;
    private int round;
    private ArrayList<Team> teams;
    private Deck deck;
    private Scanner scan = new Scanner(System.in);

    private ArrayList<Player> table;
    private int dealerIdx;
    private int leadIdx;
    
    private GameUi ui;
    private int trumpCheck;
    private Team trumpTeam;

    /**
     *
     * @param ui
     */
    public void setGameUi(GameUi ui)
    {
        this.ui = ui;
    }
    
    /**
     *
     * @param ui
     */
    public void setUi(GameUi ui)
    {
        this.ui = ui;
    }

    /**
     *
     * game
     */
    public Game() 
    {
        createTeams();
        //outputTeams();
        generateDeck();

        setTable();

        //System.out.println("*********************************");
        //System.out.println("         DEALING THE HAND        ");
        //System.out.println("*********************************");
        dealHand();
        displayHands();
        
        //setGameUi(ui);
        //play();
    }

    private void createTeams() {
        teams = new ArrayList();

        Team teamOne = new Team();
        teamOne.setTeamName("Team One");
        teams.add(teamOne);

        Team teamTwo = new Team();
        teamTwo.setTeamName("Team Two");
        teams.add(teamTwo);

        //scan = new Scanner(System.in);
        //System.out.println("Enter human player name");
        //String name = scan.next();
        String name = JOptionPane.showInputDialog(null, "Enter human player name:");

        HumanPlayer hp = new HumanPlayer();
        hp.setName(name);
        hp.setGame(this);
        //System.out.println("Human Player added to Team One!");
        teamOne.getTeam().add(hp);

        for (int p = 1; p <= Constants.NUM_AI_PLAYERS; p++)
        {
            AiPlayer aip = new AiPlayer();
            aip.setName("AI-" + p);
            aip.setGame(this);
            
            if(teamOne.getTeam().size() < 2)
            {
                teamOne.getTeam().add(aip);
            }
            else
            {
                teamTwo.getTeam().add(aip);
            }
        }
    }

    private void setTable() {
        //ArrayList 
        table = new ArrayList();

        Team teamOne = teams.get(Constants.ONE);
        Team teamTwo = teams.get(Constants.TWO);

        Player teamOnePlayerOne = teamOne.getTeam().get(Constants.ONE);
        Player teamOnePlayerTwo = teamOne.getTeam().get(Constants.TWO);
        Player teamTwoPlayerOne = teamTwo.getTeam().get(Constants.ONE);
        Player teamTwoPlayerTwo = teamTwo.getTeam().get(Constants.TWO);

        table.add(0, teamOnePlayerOne);
        table.add(1, teamOnePlayerTwo);
        table.add(2, teamTwoPlayerOne);
        table.add(3, teamTwoPlayerTwo);

        System.out.println("Players at the table are");
        for (Player player : table) {
            System.out.println(player.getName());
        }
    }

    private void setDealerandLead() {
        Random random = new Random();
        dealerIdx = random.nextInt(Constants.NUM_PLAYERS);
        dealer = table.get(dealerIdx);

        if (dealerIdx < 3) {
            leadIdx = ++dealerIdx;
        } else {
            leadIdx = 0;
        }

        leadPlayer = table.get(leadIdx);
    }

    private void dealHand() {
        setDealerandLead();

        System.out.println("Player " + dealer.getName()
                + " will deal the hand");

        int playerIdx = leadIdx;

        Iterator<Card> currentCard = deck.getCardList().iterator();

        //System.out.println("*********************************");
        //System.out.println("    First Deal, Two Cards Each   ");
        //System.out.println("*********************************");
        for (int i = 0; i < Constants.NUM_PLAYERS; i++) {
            dealOne(playerIdx, currentCard);

            if (playerIdx >= 3) {
                playerIdx = 0;
            } else {
                playerIdx++;
            }
        }

        //System.out.println("*********************************");
        //System.out.println("    Second Deal, Three Cards Each");
        //System.out.println("*********************************");
        for (int i = 0; i < Constants.NUM_PLAYERS; i++) {
            dealTwo(playerIdx, currentCard);

            if (playerIdx >= 3) {
                playerIdx = 0;
            } else {
                playerIdx++;
            }
        }

        trump = currentCard.next();

        System.out.println("*********************************");
        System.out.println("Trump card is " + trump.getFace() + " of "
                + trump.getSuit() + " color " + trump.getColor());
        System.out.println("*********************************");

    }

    private void dealOne(int playerIdx, Iterator<Card> currentCard) {
        for (int j = 0; j < Constants.DEAL_ONE; j++) {
            if (currentCard.hasNext()) {
                Card card = currentCard.next();

                //System.out.println("Dealing " + card.getFace() + " of "
                //                    + card.getSuit() + " to player " + 
                //                    table.get(playerIdx).getName());
                table.get(playerIdx).getHand().add(card);
                currentCard.remove();
            }
            //currentCard.remove();
        }
    }

    private void dealTwo(int playerIdx, Iterator<Card> currentCard) {
        for (int j = 0; j < Constants.DEAL_TWO; j++) {
            if (currentCard.hasNext()) {
                Card card = currentCard.next();

                //System.out.println("Dealing " + card.getFace() + " of "
                //                    + card.getSuit() + " to player " + 
                //                    table.get(playerIdx).getName());
                table.get(playerIdx).getHand().add(card);
                currentCard.remove();
            }
            //currentCard.remove();
        }
    }

    private void displayHands()
    {
        for (Team team : teams)
        {
            team.outputHands();
        }
    }

    private void outputTeams()
    {
        for (Team team : teams)
        {
            team.outputTeams();
        }
    }

    private void generateDeck()
    {
        deck = new Deck();
    }

    /**
     *
     * play
     */
    public void play()
    {
        //for (Player player : table)
        //{
        //    makeTrump();
        //}
        trumpCheck();
    }

    private void trumpCheck()
    {
        setTrumpCheck(0);
        
        int playerIdx = leadIdx;
        
        while(getTrumpCheck() < Constants.NUM_PLAYERS)
        {
            Player player = table.get(playerIdx);
            player.makeTrump();
            
            if(player.getAcceptTrump())
            {
                for(Team team : teams)
                {
                    if(team.getTeam().contains(player))
                    {
                        trumpTeam = team;
                        JOptionPane.showMessageDialog(null, team.getTeamName() + 
                                " has called trump");
                    }
                }
                break;
            }
            else
            {
                setTrumpCheck(getTrumpCheck() + 1);
            }
            
            if(playerIdx == 3)
                playerIdx = 0;
            else
                playerIdx++;
        }
    }
    
    /**
     *
     * @return
     */
    public Card getTrump() {
        return trump;
    }

    /**
     *
     * @param trump
     */
    public void setTrump(Card trump) {
        this.trump = trump;
    }

    /**
     *
     * @return
     */
    public Player getLeadPlayer() {
        return leadPlayer;
    }

    /**
     *
     * @param leadPlayer
     */
    public void setLeadPlayer(Player leadPlayer) {
        this.leadPlayer = leadPlayer;
    }

    /**
     *
     * @return
     */
    public Player getDealer() {
        return dealer;
    }

    /**
     *
     * @param dealer
     */
    public void setDealer(Player dealer) {
        this.dealer = dealer;
    }

    /**
     *
     * @return
     */
    public Player getWonTrick() {
        return wonTrick;
    }

    /**
     *
     * @param wonTrick
     */
    public void setWonTrick(Player wonTrick) {
        this.wonTrick = wonTrick;
    }

    /**
     *
     * @return
     */
    public int getRound() {
        return round;
    }

    /**
     *
     * @param round
     */
    public void setRound(int round) {
        this.round = round;
    }

    /**
     *
     * @return
     */
    public ArrayList<Team> getTeams() {
        return teams;
    }

    /**
     *
     * @param teams
     */
    public void setTeams(ArrayList<Team> teams) {
        this.teams = teams;
    }

    /**
     *
     * @return
     */
    public Deck getDeck() {
        return deck;
    }

    /**
     *
     * @param deck
     */
    public void setDeck(Deck deck) {
        this.deck = deck;
    }

    /**
     *
     * @return
     */
    public Scanner getScan() {
        return scan;
    }

    /**
     *
     * @param scan
     */
    public void setScan(Scanner scan) {
        this.scan = scan;
    }

    /**
     *
     * @return
     */
    public ArrayList<Player> getTable() {
        return table;
    }

    /**
     *
     * @param table
     */
    //public void setTable(ArrayList<Player> table) {
    //    this.table = table;
    //}
    /**
     *
     * @return
     */
    public int getDealerIdx() {
        return dealerIdx;
    }

    /**
     *
     * @param dealerIdx
     */
    public void setDealerIdx(int dealerIdx) {
        this.dealerIdx = dealerIdx;
    }

    /**
     *
     * @return
     */
    public int getLeadIdx() {
        return leadIdx;
    }

    /**
     *
     * @param leadIdx
     */
    public void setLeadIdx(int leadIdx) {
        this.leadIdx = leadIdx;
    }

    private void makeTrump() {
        //nothing
    }

}
