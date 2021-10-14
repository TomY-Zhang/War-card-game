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
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
//        APConsole console = new APConsole();
        WarGUI war = new WarGUI();
//        while (true) {
//            console.println("What would you like to do?\n"
//                          + "1. Play a game of war\n"
//                          + "2. Exit the program");
//            int choice = console.nextInt();
//            switch (choice) {
//                case 1:
//                    console.println("\nGame initiated!\n");
//                    while (true) {
//                        console.println("Press...\n"
//                                      + "'1' To initiate the next round\n"
//                                      + "'2' To exit the game");
//                        int choice2 = console.nextInt();
//                        
//                        boolean stop = false;
//                        switch (choice2) {
//                            case 1:
//                                war.nextRound();
//                                int result = war.getGameResult();
//                                String events = "\n";
//                                switch (result) {
//                                    case 0:
//                                        events += "Round " + war.getRound() + "\n";
//                                        for (int i = 0; i < war.getNumTiesInRound(); i++)
//                                            events += "Tie! ---> ";
//
//                                        if (war.getRoundWinner() == 1)
//                                            events += "P1 wins the round!";
//                                        else
//                                            events += "P2 wins the round!";
//
//                                        events += "\nP1 Card and Score: " + war.getP1CurrentCard() + ", " + war.getP1NumCardsWon()
//                                                + "\nP2 Card and Score: " + war.getP2CurrentCard() + ", " + war.getP2NumCardsWon()
//                                                + "\nCards left in each player's deck: " + war.getP1NumCards();
//                                        break;
//                                     
//                                    case 1:
//                                        events += "Game finished. Player 1 Wins!";
//                                        stop = true;
//                                        break;
//                                        
//                                    case 2: 
//                                        events += "Game finished. Player 2 Wins!";
//                                        stop = true;
//                                        break;
//                                        
//                                    default:
//                                        events += "Game finished. Tie game!";
//                                        stop = true;
//                                        break;
//                                }
//                                
//                                console.println(events + "\n");
//                                break;
//                            case 2:
//                                stop = true;
//                                console.print("\n");
//                                break;
//                                
//                            default:
//                                console.println("\nNot a valid option!\n");
//                        }
//                        
//                        if (stop)
//                            break;
//                    }
//                    
//                    war.newGame();
//                    break;
//                case 2:
//                    console.close();
//                    
//                default:
//                    console.println("\nNot a valid option!\n");
//            }
//        }
    }
    
}
