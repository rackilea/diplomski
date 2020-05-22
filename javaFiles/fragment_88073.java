import java.awt.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.IOException;
import java.net.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class DrawImagePanelKeyBindings extends JPanel {
   public static final String IMAGE_PATH = "https://duke.kenai.com/"
         + "nyanya/.Midsize/NyaNya.jpg.png";
   private static final double MULTIPLIER = 1.2;
   double scale = 1.0;
   private Image image;
   private Dimension initialSize = new Dimension(0, 0);

   public static void main(String[] args) {
      SwingUtilities.invokeLater(new Runnable() {
         public void run() {
            DrawImagePanelKeyBindings drawImage = new DrawImagePanelKeyBindings();
            drawImage.add(new JButton("Foo"));
            JFrame frame = new JFrame("Draw Image");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.add(drawImage);
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
         }
      });
   }

   public DrawImagePanelKeyBindings() {
      setBindings();
      URL imgURL;
      try {
         imgURL = new URL(IMAGE_PATH);
         image = ImageIO.read(imgURL);
         initialSize = new Dimension(image.getWidth(this),
               image.getHeight(this));
         setVisible(true);
      } catch (MalformedURLException e) {
         e.printStackTrace();
      } catch (IOException e) {
         e.printStackTrace();
      }
   }

   private void setBindings() {
      int condition = WHEN_IN_FOCUSED_WINDOW;
      InputMap inputMap = getInputMap(condition);
      ActionMap actionMap = getActionMap();

      final KeyStroke[] keyStrokes = {
            KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0),
            KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0)
      };
      for (final KeyStroke keyStroke : keyStrokes) {
         inputMap.put(keyStroke, keyStroke.toString());
         actionMap.put(keyStroke.toString(), new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent evt) {
               myKeyPressed(keyStroke.getKeyCode());
            }
         });
      }
   }

   @Override
   public Dimension getPreferredSize() {
      return initialSize;
   }

   @Override
   protected void paintComponent(Graphics g) {
      super.paintComponent(g);
      g.setColor(Color.BLACK);
      g.fillRect(0, 0, getSize().width, getSize().height);
      Graphics2D g2d = (Graphics2D) g.create();
      g2d.scale(scale, scale);
      g2d.drawImage(image, 0, 0, this);
   }

   public void myKeyPressed(int key) {
      if (key == KeyEvent.VK_UP) {
         scale *= MULTIPLIER;
      }
      if (key == KeyEvent.VK_DOWN) {
         scale /= MULTIPLIER;
      }
      repaint();
   }
}