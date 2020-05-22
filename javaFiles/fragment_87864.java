import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.event.*;
import java.util.HashMap;
import java.util.Map;
import javax.swing.*;

public class KeyBindingTest {
   // start gui
   private static void createAndShowGui() {
      KeyBindingPanel mainPanel = new KeyBindingPanel();

      JFrame frame = new JFrame("Key Binding Example");
      frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      frame.getContentPane().add(mainPanel);
      frame.pack();
      frame.setLocationByPlatform(true);
      frame.setVisible(true);
   }

   // start all in a thread safe manner
   public static void main(String[] args) {
      SwingUtilities.invokeLater(new Runnable() {
         public void run() {
            createAndShowGui();
         }
      });
   }
}

class KeyBindingPanel extends JPanel {
   private static final long serialVersionUID = 1L;
   private static final int PREF_W = 600;
   private static final int PREF_H = PREF_W;
   private static final Color BACKGROUND = Color.WHITE;
   private Color ovalColor = Color.blue;
   private int ovalX = PREF_W / 2;
   private int ovalY = PREF_H / 2;
   private int ovalWidth = 100;

   public KeyBindingPanel() {
      setName("Key Binding Eg");
      setBackground(BACKGROUND);

      final Map<Color, Integer> colorKeyMap = new HashMap<>();
      colorKeyMap.put(Color.BLUE, KeyEvent.VK_B);
      colorKeyMap.put(Color.RED, KeyEvent.VK_R);
      colorKeyMap.put(Color.GREEN, KeyEvent.VK_G);

      // set Key Bindings
      int condition = WHEN_IN_FOCUSED_WINDOW;
      InputMap inputMap = getInputMap(condition);
      ActionMap actionMap = getActionMap();

      for (final Color color : colorKeyMap.keySet()) {
         int keyCode = colorKeyMap.get(color);
         KeyStroke keyStroke = KeyStroke.getKeyStroke(keyCode, 0);
         inputMap.put(keyStroke, keyStroke.toString());
         actionMap.put(keyStroke.toString(), new ColorAction(color));
      }

      MyMouse myMouse = new MyMouse();
      addMouseMotionListener(myMouse);
   }

   public void setOvalColor(Color color) {
      ovalColor = color;
      repaint();
   }

   public void setOvalPosition(Point p) {
      ovalX = p.x;
      ovalY = p.y;
      repaint();
   }

   @Override
   protected void paintComponent(Graphics g) {
      super.paintComponent(g);
      Graphics2D g2 = (Graphics2D) g;
      g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
            RenderingHints.VALUE_ANTIALIAS_ON);
      g2.setColor(ovalColor);
      int x = ovalX - ovalWidth / 2;
      int y = ovalY - ovalWidth / 2;
      g2.fillOval(x, y, ovalWidth, ovalWidth);
   }

   @Override // make panel bigger
   public Dimension getPreferredSize() {
      if (isPreferredSizeSet()) {
         return super.getPreferredSize();
      }
      return new Dimension(PREF_W, PREF_H);
   }   
}

class ColorAction extends AbstractAction {
   private static final long serialVersionUID = 1L;
   private Color color;

   public ColorAction(Color color) {
      this.color = color;
   }

   @Override
   public void actionPerformed(ActionEvent e) {
      // get reference to bound component
      KeyBindingPanel panel = (KeyBindingPanel) e.getSource();
      panel.setOvalColor(color);
   }
}

class MyMouse extends MouseAdapter {
   @Override
   public void mouseMoved(MouseEvent e) {
      // get reference to listened-to component
      KeyBindingPanel panel = (KeyBindingPanel) e.getSource();
      panel.setOvalPosition(e.getPoint());
   }
}