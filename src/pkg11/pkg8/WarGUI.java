/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg11.pkg8;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
/**
 *
 * @author tommu
 */
public class WarGUI extends JFrame {
    
    private War war = new War();
    private JLabel roundLabel = new JLabel("Round :");
    private JLabel p1ScoreLabel = new JLabel("P1 Score: 0");
    private JLabel p2ScoreLabel = new JLabel("P2 Score: 0");
    private JLabel p1NumCardsLabel = new JLabel("Cards Remaining: 26");
    private JLabel p2NumCardsLabel = new JLabel("Cards Remaining: 26");
    private JPanel imagePanel = new JPanel( new GridLayout(1, 2) );
    private JPanel p1Card = new JPanel();
    private JPanel p2Card = new JPanel();
    private JTextField eventField = new JTextField("");
    private final JButton playButton = new JButton("Play");
    private final JButton resetButton = new JButton("Reset Game");
    
    public WarGUI () {
        JPanel dataPanel = new JPanel( new GridLayout(4, 2) );
        dataPanel.add(roundLabel);
        dataPanel.add(new JLabel(""));
        dataPanel.add(p1ScoreLabel);
        dataPanel.add(p2ScoreLabel);
        dataPanel.add(p1NumCardsLabel);
        dataPanel.add(p2NumCardsLabel);
        
        imagePanel.add(p1Card);
        imagePanel.add(p2Card);
        
        JPanel otherStuff = new JPanel( new GridLayout(3, 1) );
        otherStuff.add(eventField);
        otherStuff.add(playButton);
        otherStuff.add(resetButton);
        
        Container container = getContentPane();
        container.add(dataPanel, BorderLayout.NORTH);
        container.add(imagePanel, BorderLayout.CENTER);
        container.add(otherStuff, BorderLayout.SOUTH);
        
        eventField.setEditable(false);
        
        playButton.addActionListener( new playButtonListener() );
        resetButton.addActionListener( new resetButtonListener() );
        
        setTitle("War Game");
        setSize(380, 460);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    
    private class playButtonListener implements ActionListener {
        public void actionPerformed (ActionEvent e) {
            war.nextRound();
            String events = "";

            for (int i = 0; i < war.getNumTiesInRound(); i++)
                events += "Tie! --> ";

            if (war.getRoundWinner() == 1) {
                events += "Player 1 wins the round!";
            }
            else {
                events += "Player 2 wins the round!";
            }

            eventField.setText(events);
            
            p1NumCardsLabel.setText("Cards Remaining: " + war.getNumCards());
            p2NumCardsLabel.setText("Cards Remaining: " + war.getNumCards());

            p1ScoreLabel.setText("P1 Score: " + war.getP1NumCardsWon());
            p2ScoreLabel.setText("P2 Score: " + war.getP2NumCardsWon());
            
            roundLabel.setText("Round: " + war.getRound());
            
            int result = war.getGameResult();
            switch (result) {
                case 0:
                    imagePanel.removeAll();
                    p1Card = new ImagePanel(war.getP1CurrentCard().getImage());
                    p2Card = new ImagePanel(war.getP2CurrentCard().getImage());
                    imagePanel.add(p1Card);
                    imagePanel.add(p2Card);
                    imagePanel.validate();
                    break;
                case 1:
                    JOptionPane.showMessageDialog(WarGUI.this, "Player 1 Wins!");
                    break;
                case 2:
                    JOptionPane.showMessageDialog(WarGUI.this, "Player 2 Wins!");
                    break;
                case 3:
                    JOptionPane.showMessageDialog(WarGUI.this, "Tie Game!");
                    break;
                default:
                    JOptionPane.showMessageDialog(WarGUI.this, "Game already finished!");
                    break;
            }
        }
    }
    
    private class resetButtonListener implements ActionListener {
        public void actionPerformed (ActionEvent e) {
            war = new War();
            roundLabel.setText("Round: ");
            p1ScoreLabel.setText("P1 Score: 0");
            p2ScoreLabel.setText("P2 Score: 0");
            p1NumCardsLabel.setText("Cards Remaining: 26");
            p2NumCardsLabel.setText("Cards Remaining: 26");
            eventField.setText("");
            
            imagePanel.removeAll();
            imagePanel.add( new JPanel() );
            imagePanel.add( new JPanel() );
            imagePanel.revalidate();
        }
    }
}
