import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

@SuppressWarnings("serial")
class TrafficLight3 extends JFrame {
   private static final int DIAMETER = 100;
   private static final Color[] COLORS = { Color.red, Color.yellow, Color.green };
   private StopLightPanel[] lightPanels = new StopLightPanel[COLORS.length];

   public static void main(String[] args) {
      SwingUtilities.invokeLater(new Runnable() {
         public void run() {
            new TrafficLight3();
         }
      });
   }

   public TrafficLight3() {
      setTitle("Traffic Light");
      setLayout(new GridLayout(3, 1));
      setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

      MouseAdapter mouseClicked = new MouseClicked();
      for (int i = 0; i < COLORS.length; i++) {
         lightPanels[i] = new StopLightPanel(DIAMETER, COLORS[i]);
         lightPanels[i].addMouseListener(mouseClicked);
         add(lightPanels[i]);
      }
      pack();
      setLocationRelativeTo(null);
      setVisible(true);
   }

   class MouseClicked extends MouseAdapter {
      // better overriding mousePressed not mouseClicked
      @Override
      public void mousePressed(MouseEvent me) {
         // set all lights dark
         for (StopLightPanel lightPanel : lightPanels) {
            lightPanel.setLightOn(false);
         }

         // turn only selected light on.
         ((StopLightPanel) me.getSource()).setLightOn(true);
      }
   }

   class StopLightPanel extends JPanel {
      // avoid "magic" numbers
      private static final int GAP = 10;
      private int diameter;
      private Color onColor;
      private Color offColor;
      private boolean lightOn;

      public boolean isLightOn() {
         return lightOn;
      }

      public void setLightOn(boolean lightOn) {
         this.lightOn = lightOn;
         repaint();
      }

      public StopLightPanel(int diameter, Color color) {
         this.diameter = diameter;
         this.onColor = color.brighter();
         this.offColor = color.darker().darker();
         this.lightOn = false;
      }

      @Override
      public Dimension getPreferredSize() {
         int prefW = diameter + 2 * GAP;
         int prefH = prefW;
         return new Dimension(prefW, prefH);
      }

      @Override
      protected void paintComponent(Graphics g) {
         super.paintComponent(g);
         Graphics2D g2 = (Graphics2D) g;
         // smooth out the edge of our circle
         g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
               RenderingHints.VALUE_ANTIALIAS_ON);
         Color color = lightOn ? onColor : offColor;
         g2.setColor(color);
         g2.fillOval(GAP, GAP, diameter, diameter);
      }
   }
}