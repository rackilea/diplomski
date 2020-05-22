import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.util.*;
import java.util.List;

class EcadB extends JPanel {
   private static final int PREF_W = 800;
   private static final int PREF_H = 600;
   private List<MyShape> myShapes = new ArrayList<MyShape>();
   private double scale = 1.0;
   private JSlider slider = new JSlider(0, 200, 100);

   public EcadB() {
      addMouseListener(new MyMouseAdapter());
      setLayout(new BorderLayout());

      slider.setOpaque(false);
      slider.setMajorTickSpacing(20);
      slider.setMinorTickSpacing(10);
      slider.setPaintLabels(true);
      slider.setPaintTicks(true);
      slider.addChangeListener(new SliderChangeListener());
      add(slider, BorderLayout.SOUTH);
   }

   @Override
   protected void paintComponent(Graphics g) {
      super.paintComponent(g);
      Graphics2D g2 = (Graphics2D) g;
      g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
            RenderingHints.VALUE_ANTIALIAS_ON);
      Graphics2D g2b = (Graphics2D)g2.create();
      g2b.scale(scale, scale);
      for (MyShape myShape : myShapes) {
         myShape.draw(g2b, scale);
      }
      g2b.dispose();
   }

   public void setScale(double scale) {
      this.scale = scale;
      repaint();
   }

   @Override
   public Dimension getPreferredSize() {
      return new Dimension(PREF_W, PREF_H);
   }

   private class MyMouseAdapter extends MouseAdapter {
      @Override
      public void mousePressed(MouseEvent e) {
         Point2D p1 = e.getPoint();
         Point2D p2 = new Point((int) (p1.getX() - 100),
               (int) (p1.getY() + (1.732 / 2 * 200)));
         Point2D p3 = new Point((int) (p1.getX() + 100),
               (int) (p1.getY() + (1.732 / 2 * 200)));
         Path2D path = new Path2D.Double();
         path.moveTo(p1.getX(), p1.getY());
         path.lineTo(p2.getX(), p2.getY());
         path.lineTo(p3.getX(), p3.getY());
         path.lineTo(p1.getX(), p1.getY());

         myShapes.add(new MyShape(path, p1));
         repaint();
      }
   }

   private class SliderChangeListener implements ChangeListener {
      @Override
      public void stateChanged(ChangeEvent arg0) {
         double value = slider.getValue() / 100.0;
         setScale(value);
      }
   }

   public static void main(String args[]) {
      // new Ecad();
      SwingUtilities.invokeLater(new Runnable() {
         public void run() {
            EcadB ecadB = new EcadB();
            JFrame frame = new JFrame("Scale");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.getContentPane().add(ecadB);
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
         }
      });
   }
}

class MyShape {
   Shape shape;
   Point2D fixedPoint;

   public MyShape(Shape shape, Point2D fixedPoint) {
      this.shape = shape;
      this.fixedPoint = fixedPoint;
   }

   public void draw(Graphics2D g2, double scale) {
      Graphics2D g2b = (Graphics2D) g2.create();
      double tx = fixedPoint.getX() * (1.0 - scale) / scale;
      double ty = fixedPoint.getY() * (1.0 - scale) / scale;
      g2b.translate(tx, ty);
      g2b.draw(shape);
      g2b.dispose();
   }
}