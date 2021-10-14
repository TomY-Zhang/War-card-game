/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg11.pkg8;
import javax.swing.ImageIcon;
/**
 *
 * @author tommu
 */
public class Card {
    
    private final int rank;
    private final String suit;
    private ImageIcon image;
    
    public Card (int num, String st, ImageIcon img) {
        rank = num;
        suit = st;
        image = img;
    }
    
    public Card (int num, String st, String dir) {
        rank = num;
        suit = st;
        try {
            image = new ImageIcon(dir);
        }
        catch (Exception e) {
            image = null;
        }
    }
    
    public int compareTo (Card other) {
        if (rank == other.getRank()) {
            return 0;
        } else if (rank > other.getRank()) {
            return 1;
        }
        
        return -1;
    }
    
    public int getRank () {
        return rank;
    }
    
    public String getSuit () {
        return suit;
    }
    
    public ImageIcon getImage () {
        return image;
    }
    
    public String toString () {
        if (rank <= 10) {
            return rank + " of " + suit + "s";
        } else if (rank == 11) {
            return "Jack of" + suit + "s";
        } else if (rank == 12) {
            return "Queen of" + suit + "s";
        } else if (rank == 13) {
            return "King of" + suit + "s";
        }
        
        return "Ace of" + suit + "s";
    }
}
