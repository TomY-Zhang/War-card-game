/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg11.pkg8;
import java.awt.*;
import javax.swing.*;
/**
 *
 * @author TZ228593
 */
public class ImagePanel extends JPanel {
    
    private ImageIcon image = null;
    
    public ImagePanel (ImageIcon img) {
        image = img;
    }
    
    @Override
    public void paintComponent (Graphics g) {
        super.paintComponent(g);
        try {
            resize();
            image.paintIcon(this, g, 0, 0);
        } catch (Exception e) {
            
        }
    }
    
    public void resize () {
        Image img = image.getImage(); // transform it 
        Image newimg = img.getScaledInstance(180, 270,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
        image = new ImageIcon(newimg);
    }
}
