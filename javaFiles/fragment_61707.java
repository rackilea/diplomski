import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

public class ActivateMouse extends JPanel {
   private static final int PREF_W = 400;
   private static final int PREF_H = PREF_W;
   private static final Color DRAW_RECT_COLOR = Color.pink.brighter();
   private static final Color DRAW_ALL_RECTS_COLOR = Color.red;
   private boolean mouseActive = false;
   private Shape drawRect = null;
   private List<Shape> shapeList = new ArrayList<>();
   private ButtonAction buttonAction = new ButtonAction("Create New Rectangle", KeyEvent.VK_C);

   public ActivateMouse() {
      MyMouseAdapter myMouseAdapter = new MyMouseAdapter();
      addMouseListener(myMouseAdapter);
      addMouseMotionListener(myMouseAdapter);

      add(new JButton(buttonAction));
   }

   @Override
   protected void paintComponent(Graphics g) {
      super.paintComponent(g);
      Graphics2D g2 = (Graphics2D) g;
      if (drawRect != null) {
         g2.setColor(DRAW_RECT_COLOR);
         g2.draw(drawRect);
      }

      g2.setColor(DRAW_ALL_RECTS_COLOR);
      for (Shape shape : shapeList) {
         g2.draw(shape);
      }
   }

   @Override
   public Dimension getPreferredSize() {
      if (isPreferredSizeSet()) {
         return super.getPreferredSize();
      }
      return new Dimension(PREF_W, PREF_H);
   }

   private class MyMouseAdapter extends MouseAdapter {
      private Point firstPt;

      @Override
      public void mousePressed(MouseEvent e) {
         if (mouseActive && e.getButton() == MouseEvent.BUTTON1) {
            firstPt = e.getPoint();
         }
      }

      @Override
      public void mouseDragged(MouseEvent e) {
         if (!mouseActive || firstPt == null) {
            return;
         }
         drawRect = createRect(e.getPoint());
         repaint();
      }

      @Override
      public void mouseReleased(MouseEvent e) {
         if (!mouseActive || firstPt == null) {
            return;
         }
         shapeList.add(createRect(e.getPoint()));
         repaint();
         mouseActive = false;
      }

      private Shape createRect(Point p) {
         int x = Math.min(firstPt.x, p.x);
         int y = Math.min(firstPt.y, p.y);
         int width = Math.abs(firstPt.x - p.x);
         int height = Math.abs(firstPt.y - p.y);
         return new Rectangle(x, y, width, height);
      }
   }

   private class ButtonAction extends AbstractAction {
      public ButtonAction(String name, int mnemonic) {
         super(name);
         putValue(MNEMONIC_KEY, mnemonic);
      }

      @Override
      public void actionPerformed(ActionEvent e) {
         mouseActive = true;
      }
   }

   private static void createAndShowGui() {
      JFrame frame = new JFrame("ActivateMouse");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().add(new ActivateMouse());
      frame.pack();
      frame.setLocationRelativeTo(null);
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