import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class CircuitTracePlot2 extends JPanel {

   private static final int PREF_W = 250;
   private static final int PREF_H = PREF_W;

   private int drawWidth = 160;
   private int drawHeight = drawWidth;
   private int drawX = 10;
   private int drawY = 10;
   private PaintType paintType = PaintType.LINE;

   public CircuitTracePlot2() {

   }

   @Override
   public Dimension getPreferredSize() {
      return new Dimension(PREF_W, PREF_H);
   }

   public void setPaintType(PaintType paintType) {
      this.paintType = paintType;
      repaint();
   }

   @Override
   protected void paintComponent(Graphics g) {
      super.paintComponent(g);
      if (paintType == null) {
         return;
      }
      switch (paintType) {
      case LINE:
         g.drawLine(drawX, drawY, drawWidth, drawHeight);
         break;
      case OVAL:
         g.drawOval(drawX, drawY, drawWidth, drawHeight);
         break;
      case SQUARE:
         g.drawRect(drawX, drawY, drawWidth, drawHeight);

      default:
         break;
      }
   }

   private static void createAndShowGui() {
      final CircuitTracePlot2 circuitTracePlot = new CircuitTracePlot2();

      JFrame frame = new JFrame("CircuitTracePlot2");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().add(circuitTracePlot);
      frame.pack();
      frame.setLocationByPlatform(true);
      frame.setVisible(true);

      int timerDelay = 2 * 1000;
      new Timer(timerDelay , new ActionListener() {
         private int paintTypeIndex = 0;

         @Override
         public void actionPerformed(ActionEvent arg0) {
            paintTypeIndex++;
            paintTypeIndex %= PaintType.values().length;
            circuitTracePlot.setPaintType(PaintType.values()[paintTypeIndex]);
         }
      }).start();
   }

   public static void main(String[] args) {
      SwingUtilities.invokeLater(new Runnable() {
         public void run() {
            createAndShowGui();
         }
      });
   }
}

enum PaintType {
   LINE, OVAL, SQUARE;
}