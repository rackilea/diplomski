import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class JavaGame2 extends JPanel {
   private static final int PREF_W = 600;
   private static final int PREF_H = 400;
   private static final Font LABEL_FONT = new Font("Arial", Font.BOLD, 20);
   private static final Color[] FOREGROUNDS = { new Color(0x009900),
         new Color(0x990000), new Color(0x000099), new Color(0x999900),
         new Color(0x990099), new Color(0x009999) };
   private static final String[] LABEL_TEXTS = { "Hello World!",
         "Goodbye World!", "Hola Todo el Mundo!", "Hasta la Vista Baby!",
         "Whatever!!" };

   private JButton changetextButton;
   private JButton changeColorButton;
   private JLabel label;
   private int labelTextIndex = 0;
   private int foregroundIndex = 0;

   public JavaGame2() {
      label = new JLabel(LABEL_TEXTS[labelTextIndex], SwingConstants.CENTER);
      label.setFont(LABEL_FONT);
      label.setForeground(FOREGROUNDS[foregroundIndex]);

      // example of anonymous inner ActionListener:
      changetextButton = new JButton("Change Text");
      changetextButton.addActionListener(new ActionListener() {

         @Override
         public void actionPerformed(ActionEvent evt) {
            labelTextIndex++;
            labelTextIndex %= LABEL_TEXTS.length;
            label.setText(LABEL_TEXTS[labelTextIndex]);
         }
      });

      // example of use of an anonymous AbstractAction:
      changeColorButton = new JButton(new AbstractAction("Change Color") {

         @Override
         public void actionPerformed(ActionEvent e) {
            foregroundIndex++;
            foregroundIndex %= FOREGROUNDS.length;
            label.setForeground(FOREGROUNDS[foregroundIndex]);
         }
      });

      setLayout(new BorderLayout());
      add(changetextButton, BorderLayout.NORTH);
      add(changeColorButton, BorderLayout.SOUTH);
      add(label, BorderLayout.CENTER);
   }

   @Override
   public Dimension getPreferredSize() {
      return new Dimension(PREF_W, PREF_H);
   }

   private static void createAndShowGui() {
      JavaGame2 mainPanel = new JavaGame2();

      JFrame frame = new JFrame("Java Game 2");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().add(mainPanel);
      frame.pack();
      frame.setLocationByPlatform(true);
      frame.setVisible(true);
   }

   public static void main(String[] args) {
      SwingUtilities.invokeLater(new Runnable() {
         public void run() {
            createAndShowGui();
         }
      });
   }
}