import javax.swing.JFrame;
import java.awt.Graphics;
import javax.swing.JPanel;
import javax.swing.*;
import java.awt.MouseInfo;
import java.awt.Component;

public class Name extends JFrame {
     public Name() {
         super("Name");
         setTitle("Application");
         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         setSize(400,400);
         setResizable(true);
         setContentPane(new Pane());
         setVisible(true);
         int x;
         int y;
         Component[] rel;
         while (true){
              rel = getComponents();
              x=MouseInfo.getPointerInfo().getLocation().x-rel[0].getLocationOnScreen().x;
              y=MouseInfo.getPointerInfo().getLocation().y-rel[0].getLocationOnScreen().y;
              System.out.println("X : "+Integer.toString(x)+" Y : "+Integer.toString(y));
              try { //Update screen every 33 miliseconds = 25 FPS
              Thread.sleep(33);
              } catch(InterruptedException bug) {
              Thread.currentThread().interrupt();
              System.out.println(bug);
              }
         }
     }
     class Pane extends JPanel {
         public void paintComponent(Graphics g) { //Here is were you can draw your stuff
             g.drawString("Hello World",0,20); //Display text
         }
     }
     public static void main(String args[]){
         new Name();
     }
}