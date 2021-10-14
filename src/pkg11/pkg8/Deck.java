/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg11.pkg8;
import java.util.Random;
/**
 *
 * @author tommu
 */
public class Deck {
    
    private Card[] deck = new Card[52];
    private String directory;
    private int index = 0;
    
    public Deck (String dir) {
        directory = dir;
        reset();
    }
    
    public void reset () {
        int index = 0;
        for (int i = 2; i < 15; i++) {
            deck[index++] = new Card (i, "Club", directory + i + "C.png");
            deck[index++] = new Card (i, "Club", directory + i + "D.png");
            deck[index++] = new Card (i, "Club", directory + i + "H.png");
            deck[index++] = new Card (i, "Club", directory + i + "S.png");
        }
    }
    
    public void shuffle () {
        Random rand = new Random();
        int index1;
        int index2;
        
        for (int i = 0; i < 200; i++) {
            index1 = rand.nextInt(52);
            index2 = rand.nextInt(52);
            
            Card other = deck[index1];
            deck[index1] = deck[index2];
            deck[index2] = other;
        }
    }
    
    public Card getCard (int index) {
        if (0 <= index && index <= 52)
            return deck[index];
        else
            return null;
    }
    
    public Card nextCard () {
        if(index < 52)
            return deck[index++];
        else
            return null;
    }
}
