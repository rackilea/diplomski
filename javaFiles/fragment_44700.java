import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.*;

public class ScrollPaneArtifacts extends JPanel {
   private static final int SPA_WIDTH = 600;
   private static final int SPA_HEIGHT = SPA_WIDTH;

   @Override
   protected void paintComponent(Graphics g) {
      //super.paintComponent(g);
      g.setColor(Color.red);
      g.drawLine(0, 0, getWidth(), getHeight());
      g.drawLine(getWidth(), 0, 0, getHeight());
   }

   @Override
   public Dimension getPreferredSize() {
      return new Dimension(SPA_WIDTH, SPA_HEIGHT);
   }

   private static void createAndShowUI() {
      JScrollPane scrollpane = new JScrollPane(new ScrollPaneArtifacts());
      scrollpane.getViewport().setPreferredSize(new Dimension(400, 400));
      JFrame frame = new JFrame("ScrollPaneArtifacts");
      frame.getContentPane().add(scrollpane);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.pack();
      frame.setLocationRelativeTo(null);
      frame.setVisible(true);
   }

   public static void main(String[] args) {
      java.awt.EventQueue.invokeLater(new Runnable() {
         public void run() {
            createAndShowUI();
         }
      });
   }
}