import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.EnumMap;
import java.util.Map;

import javax.swing.*;

@SuppressWarnings("serial")
public class GamePanel2 extends JPanel {
   private static final int PREF_W = 600;
   private static final int PREF_H = 500;
   private static final int PADDLE_Y = 475;
   private static final int PADDLE_W = 80;
   private static final int PADDLE_H = 20;
   private static final int PADDLE_ARC = 15;
   private static final int TIME_DELAY = 15;
   public static final int VEL_X = 2;
   private static final Color PADDLE_COLOR = new Color(201, 51, 51);
   private int paddleX;
   private Timer time = new Timer(TIME_DELAY, new TimerListener());

   // key presses and releases will change the boolean values held in this Map
   // When an arrow key is pressed, the direction-corresponding boolean is set true
   // and likewise when the arrow key is released the direction corresponding boolean is false
   private Map<Direction, Boolean> dirMap = new EnumMap<>(Direction.class);


   public GamePanel2() {
      setKeyBindings();
      time.start();
   }

   private void setKeyBindings() {
      int condition = WHEN_IN_FOCUSED_WINDOW;
      InputMap inputMap = getInputMap(condition);
      ActionMap actionMap = getActionMap();

      // iterate through all the Direction enums
      for (Direction direction : Direction.values()) {
         // set all values to false
         dirMap.put(direction, false);

         // create two key strokes, one for pressed and one for released
         int keyValue = direction.getKeyValue();
         KeyStroke pressedKey = KeyStroke.getKeyStroke(keyValue, 0, false);
         KeyStroke releasedKey = KeyStroke.getKeyStroke(keyValue, 0, true);

         // create two Actions, one for pressed, one for released
         Action pressedAction = new KeyAction(direction, true);
         Action releasedAction = new KeyAction(direction, false);

         // add keystroke to inputMap and use keystroke's toString as binding link
         inputMap.put(pressedKey, pressedKey.toString());
         inputMap.put(releasedKey, releasedKey.toString());

         // link binding links to our actions
         actionMap.put(pressedKey.toString(), pressedAction);
         actionMap.put(releasedKey.toString(), releasedAction);
      }

   }

   @Override
   public Dimension getPreferredSize() {
      if (isPreferredSizeSet()) {
         return super.getPreferredSize();
      }
      return new Dimension(PREF_W, PREF_H);
   }

   @Override
   protected void paintComponent(Graphics g) {
      super.paintComponent(g);
      Graphics2D g2 = (Graphics2D) g;
      g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
            RenderingHints.VALUE_ANTIALIAS_ON);
      g.setColor(PADDLE_COLOR);
      g.fillRoundRect(paddleX, PADDLE_Y, PADDLE_W, PADDLE_H, PADDLE_ARC, PADDLE_ARC);
   }

   private class TimerListener implements ActionListener {
      @Override
      public void actionPerformed(ActionEvent e) {
         // if JPanel no longer displayed, stop the Timer
         if (!GamePanel2.this.isDisplayable()) {
            ((Timer) e.getSource()).stop();
         }
         // here's the key: iterate through the Direction enum
         for (Direction direction : Direction.values()) {
            // get corresponding boolean from dirMap
            // and if true, change location of x and y
            if (dirMap.get(direction)) {
               int possibleX = paddleX + VEL_X * direction.getDeltaX();
               if (direction == direction.RIGHT && possibleX + PADDLE_W <= getWidth()) {
                  paddleX = possibleX;
               }
               if (direction == Direction.LEFT && possibleX >= 0) {
                  paddleX = possibleX;
               }
            }
         }
         repaint();
      }
   }

   private class KeyAction extends AbstractAction {
      private Direction direction;
      private boolean pressed;

      public KeyAction(Direction direction, boolean pressed) {
         this.direction = direction;
         this.pressed = pressed;               
      }

      @Override
      public void actionPerformed(ActionEvent e) {
         dirMap.put(direction, pressed); // key press simply changes the map, that's it.
      }
   }

   private static void createAndShowGui() {
      GamePanel2 mainPanel = new GamePanel2();

      JFrame frame = new JFrame("GamePanel2");
      frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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

enum Direction {
   LEFT("Left", KeyEvent.VK_LEFT, -1),
   RIGHT("Right", KeyEvent.VK_RIGHT, 1);

   private String text; 
   private int keyValue; // KeyEvent.VK_?
   private int deltaX; 

   Direction(String text, int keyValue, int deltaX) {
      this.text = text;
      this.keyValue = keyValue;
      this.deltaX = deltaX;
   }

   public String getText() {
      return text;
   }

   public int getKeyValue() {
      return keyValue;
   }

   @Override
   public String toString() {
      return text;
   }

   public int getDeltaX() {
      return deltaX;
   }
}