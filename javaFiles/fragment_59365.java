package complexviewer;  

import java.awt.*;  
import java.awt.event.*;    
import java.util.concurrent.*;  
import static java.util.concurrent.TimeUnit.*;  
import javax.swing.*;   

public class Applet extends JFrame {    

    // Window and applet stats  
    public static final int windowSize = 400;   
    public static final int updateDelay = 20;   

    // Instance variables   
    private ScheduledExecutorService timer = Executors.newScheduledThreadPool(1);   

    public static void main(String[] args) {    
        new Applet();   
    }   
    public Applet() {   
        // Set up window    
        super("Complex Viewing Frame"); 
        setSize(windowSize, windowSize);    
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 

        // Incorrect location for setVisible    

        // Add listeners    
        JPanel panel = new JPanel();    
        panel.setFocusable(true);   
        panel.addKeyListener(new KeyListener() {    
            public void keyPressed(KeyEvent key) {  
                System.out.println("Key pressed."); 
            }   
            public void keyReleased(KeyEvent key) {}    
            public void keyTyped(KeyEvent key) {}   
        }); 
        panel.addMouseListener(new MouseListener() {    
            public void mouseReleased(MouseEvent mouse) {}  
            public void mouseClicked(MouseEvent mouse) {}   
            public void mousePressed(MouseEvent mouse) {    
                System.out.println("Mouse clicked.");   
            }   
            public void mouseEntered(MouseEvent mouse) {}   
            public void mouseExited(MouseEvent mouse) {}    
        }); 
        panel.addMouseMotionListener(new MouseMotionListener() {    
            public void mouseDragged(MouseEvent mouse) {    
                System.out.println("Mouse dragged.");   
            }   
            public void mouseMoved(MouseEvent mouse) {} 
        }); 
        add(panel); 
        panel.requestFocus();   

        setVisible(true); // Correct location for setVisible    

        timer.scheduleAtFixedRate(() -> repaint(), 0, 200, MILLISECONDS);   
    }   

    public void paint(Graphics G) { 
        // Drawing  
    }   

}