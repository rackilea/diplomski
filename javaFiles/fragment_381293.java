import java.awt.*;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.AbstractBorder;

@SuppressWarnings("serial")
public class FrameEg extends JPanel {
   public static final String FRAME_URL_PATH = "http://th02.deviantart.net/"
         + "fs70/PRE/i/2010/199/1/0/Just_Frames_5_by_ScrapBee.png";
   public static final int INSET_GAP = 120;

   private BufferedImage frameImg;
   private BufferedImage smlFrameImg;

   public FrameEg() {
      try {
         URL frameUrl = new URL(FRAME_URL_PATH);
         frameImg = ImageIO.read(frameUrl);

         final int smlFrameWidth = frameImg.getWidth() / 2;
         final int smlFrameHeight = frameImg.getHeight() / 2;
         smlFrameImg = new BufferedImage(smlFrameWidth, smlFrameHeight,
               BufferedImage.TYPE_INT_ARGB);
         Graphics g = smlFrameImg.getGraphics();
         g.drawImage(frameImg, 0, 0, smlFrameWidth, smlFrameHeight, null);
         g.dispose();

         int top = INSET_GAP;
         int left = top;
         int bottom = top;
         int right = left;
         Insets insets = new Insets(top, left, bottom, right);
         MyBorder myBorder = new MyBorder(frameImg, insets);

         JTextArea textArea = new JTextArea(50, 60);
         textArea.setWrapStyleWord(true);
         textArea.setLineWrap(true);
         for (int i = 0; i < 300; i++) {
            textArea.append("Hello world! How is it going? ");
         }
         setLayout(new BorderLayout(1, 1));
         setBackground(Color.black);

         Dimension prefSize = new Dimension(frameImg.getWidth(),
               frameImg.getHeight());
         JPanel centerPanel = new MyPanel(prefSize);
         centerPanel.setBorder(myBorder);
         centerPanel.setLayout(new BorderLayout(1, 1));
         centerPanel.add(new JScrollPane(textArea), BorderLayout.CENTER);

         MyPanel rightUpperPanel = new MyPanel(new Dimension(smlFrameWidth,
               smlFrameHeight));
         MyPanel rightLowerPanel = new MyPanel(new Dimension(smlFrameWidth,
               smlFrameHeight));
         top = top / 2;
         left = left / 2;
         bottom = bottom / 2;
         right = right / 2;
         Insets smlInsets = new Insets(top, left, bottom, right);
         rightUpperPanel.setBorder(new MyBorder(smlFrameImg, smlInsets));
         rightUpperPanel.setLayout(new BorderLayout());
         rightLowerPanel.setBorder(new MyBorder(smlFrameImg, smlInsets));
         rightLowerPanel.setBackgroundImg(createBackgroundImg(rightLowerPanel
               .getPreferredSize()));

         JTextArea ruTextArea1 = new JTextArea(textArea.getDocument());
         ruTextArea1.setWrapStyleWord(true);
         ruTextArea1.setLineWrap(true);
         rightUpperPanel.add(new JScrollPane(ruTextArea1), BorderLayout.CENTER);

         JPanel rightPanel = new JPanel(new GridLayout(0, 1, 1, 1));
         rightPanel.add(rightUpperPanel);
         rightPanel.add(rightLowerPanel);
         rightPanel.setOpaque(false);
         add(centerPanel, BorderLayout.CENTER);
         add(rightPanel, BorderLayout.EAST);

      } catch (MalformedURLException e) {
         e.printStackTrace();
      } catch (IOException e) {
         e.printStackTrace();
      }
   }

   private BufferedImage createBackgroundImg(Dimension preferredSize) {
      BufferedImage img = new BufferedImage(preferredSize.width,
            preferredSize.height, BufferedImage.TYPE_INT_ARGB);
      Point2D center = new Point2D.Float(img.getWidth()/2, img.getHeight()/2); 
      float radius = img.getWidth() / 2;
      float[] dist = {0.0f, 1.0f};
      Color centerColor = new Color(100, 100, 50);
      Color outerColor = new Color(25, 25, 0);
      Color[] colors = {centerColor , outerColor };
      RadialGradientPaint paint = new RadialGradientPaint(center, radius, dist, colors);
      Graphics2D g2 = img.createGraphics();
      g2.setPaint(paint);
      g2.fillRect(0, 0, img.getWidth(), img.getHeight());
      g2.dispose();

      return img;
   }

   private static void createAndShowGui() {
      FrameEg mainPanel = new FrameEg();

      JFrame frame = new JFrame("FrameEg");
      frame.setUndecorated(true);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().add(mainPanel);
      frame.setResizable(false);
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

@SuppressWarnings("serial")
class MyPanel extends JPanel {
   private Dimension prefSize;
   private BufferedImage backgroundImg;

   public MyPanel(Dimension prefSize) {
      this.prefSize = prefSize;
   }

   public void setBackgroundImg(BufferedImage background) {
      this.backgroundImg = background;
   }

   @Override
   protected void paintComponent(Graphics g) {
      super.paintComponent(g);
      if (backgroundImg != null) {
         g.drawImage(backgroundImg, 0, 0, this);
      }
   }

   @Override
   public Dimension getPreferredSize() {
      return prefSize;
   }
}

@SuppressWarnings("serial")
class MyBorder extends AbstractBorder {
   private BufferedImage borderImg;
   private Insets insets;

   public MyBorder(BufferedImage borderImg, Insets insets) {
      this.borderImg = borderImg;
      this.insets = insets;
   }

   @Override
   public void paintBorder(Component c, Graphics g, int x, int y, int width,
         int height) {
      g.drawImage(borderImg, 0, 0, c);
   }

   @Override
   public Insets getBorderInsets(Component c) {
      return insets;
   }
}