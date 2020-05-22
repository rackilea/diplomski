import java.awt.*;
import java.awt.event.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.*;

public class Main {
   public static void main(String[] args) {
      new Main().go();
   }

   public void go() {
      final JFrame frame = new JFrame();
      final Grid grid = new Grid(1);
      final Menu menu = new Menu();

      // .... etc...
      frame.pack();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setVisible(true);
      frame.setLocationRelativeTo(null);
      boolean done = true; //!! was false
      boolean menuBool = true;

//      while (!done) {
//         // get rid of this 
//      }

      // instead do this -- add a property change listener to your menu JPanel
      menu.addPropertyChangeListener(new PropertyChangeListener() {

         @Override
         public void propertyChange(PropertyChangeEvent pcEvt) {
            if (Menu.CHOICE.equals(pcEvt.getPropertyName())) {
               System.out.println("Choice is: " + menu.getChoice());
            }
         }
      });
   }
}

class Menu extends JPanel {
   public static final String CHOICE = "choice";

   // each variable should get its own line
   private JButton m1
   private JButton m2;
   private JButton m3;
   private int width; 
   private int height;
   private int widthOne;
   private int heightOne;

   private int choice;  // declare each variable separately

   public Menu() {
      setChoice(0);
      widthOne = 250;

      // .... etc

      m1.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            setChoice(1);
         }
      });
      m2.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            setChoice(2);
         }
      });
      m3.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            setChoice(3);
         }
      });
   }
   //...
}