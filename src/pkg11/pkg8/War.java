/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg11.pkg8;
/**
 *
 * @author tommu
 */
public class War {
    
    private final Deck deck = new Deck("images\\");
    private final Card[] p1Cards = new Card[26];
    private final Card[] p2Cards = new Card[26];
    private int numCardsLeft;
    private int p1NumCardsWon;
    private int p2NumCardsWon;
    private Card p1CurrentCard = null;
    private Card p2CurrentCard = null;
    private int round;
    private int numTiesInRound;
    private int roundWinner;
    private int gameResult;
    private int index;
    
    public War () {
        numCardsLeft = 26;
        p1NumCardsWon = 0;
        p2NumCardsWon = 0;
        round = 0;
        numTiesInRound = 0;
        roundWinner = 0;
        gameResult = 0;
        index = 0;
        
        deck.shuffle();
        for (int i = 0; i < 26; i++) {
            p1Cards[i] = deck.nextCard();
        }
        
        for(int i = 0; i < 26; i++) {
            p2Cards[i] = deck.nextCard();
        }
    }
    
    public void nextRound () {
        if (index <= 25) {
            numTiesInRound = 0;
            p1CurrentCard = p1Cards[index];
            p2CurrentCard = p2Cards[index];
            round++;
            
            int warPile = 0;
            int comparison;
            while (index <= 25) {
                warPile += 2;
                comparison = p1CurrentCard.compareTo(p2CurrentCard);
                numCardsLeft--;
                index++;
                if (comparison == 0) {
                    numTiesInRound++;
                    if (index < 26) {
                        p1CurrentCard = p1Cards[index];
                        p2CurrentCard = p2Cards[index];
                    }
                } else if (comparison > 0) {
                    p1NumCardsWon += warPile;
                    roundWinner = 1;
                    break;
                } else {
                    p2NumCardsWon += warPile;
                    roundWinner = 2;
                    break;
                }
            }
        } else {
            if (p1NumCardsWon > p2NumCardsWon)
                gameResult = 1;
            else if (p1NumCardsWon < p2NumCardsWon)
                gameResult = 2;
            else
                gameResult = 3;
        }
    }
    
    public int getNumCards () {
        return numCardsLeft;
    }
    
    public int getP1NumCardsWon () {
        return p1NumCardsWon;
    }
    
    public int getP2NumCardsWon () {
        return p2NumCardsWon;
    }
    
    public Card getP1CurrentCard () {
        return p1CurrentCard;
    }
    
    public Card getP2CurrentCard () {
        return p2CurrentCard;
    }
    
    public int getRound () {
        return round;
    }
    
    public int getNumTiesInRound () {
        return numTiesInRound;
    }
    
    public int getRoundWinner () {
        return roundWinner;
    }
    
    public int getGameResult () {
        return gameResult;
    }
}
