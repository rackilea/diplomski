package painting;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.*;
import java.io.*;
import javax.imageio.ImageIO;


/**
 *
 * @author tt700
 */
public class Painting extends JPanel {
    // declaring variables that control movement, show the frame, and make the picture
    int x =50, y =50, counter = 0;
    private static JFrame window = new JFrame("Paint a Picture");
    private static Painting canvas;
    private static Image player;


// main method
public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable(){
    @Override
    public void run(){    
    JLabel title = new JLabel("Making a picture frame");
    window.add(title, BorderLayout.NORTH);
    canvas = new Painting();
    window.add(canvas);
    player = getImage("player.jpg");
    window.setVisible(true);
    window.setSize(300,300);
    window.setForeground(Color.red);

    }
   });
}

@Override
// the method that does all the painting
public void paintComponent(Graphics g) {
    super.paintComponent(g);
    g.drawImage(player, x, y, Painting.this);
}

// the method that gets a desired image and makes it displayable, with arguments it can be used to swap pictures easily
private static Image getImage(String imagePath){
    Image player = null;
 try{
    player = ImageIO.read(Painting.class.getResource(imagePath));
        }catch(IOException e){
            e.printStackTrace();
        }
      return player; 
}
// the class that controls movement of the picture
public class movement implements KeyListener{   

    @Override
    public void keyTyped(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    // the method that listens to which keys are pressed and acts accordingly
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_RIGHT){                
        x += 5;                
        window.repaint();
    }
    else if(e.getKeyCode() == KeyEvent.VK_LEFT){
        x -= 5;
        window.repaint();
    }
    else if(e.getKeyCode() == KeyEvent.VK_UP){
        y -= 5;
        window.repaint();
    }
    else if(e.getKeyCode() == KeyEvent.VK_DOWN){
        y += 5;
        window.repaint();
    }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }       
}

// the subclass that adds a key listener to the proper component, created since action listeners can't be called in static methods (main)
public Painting(){
    do{
    counter = 1;
    window.addKeyListener(new movement());
    }while(counter < 1);
}