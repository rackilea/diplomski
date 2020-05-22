import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.EnumMap;

import javax.imageio.ImageIO;
import javax.swing.*;

@SuppressWarnings("serial")
public class StopLightApp extends JPanel {
   private static final String IMG_PATH = "http://urbannight.files.wordpress.com/2012/09/"
         + "red-orange-green-traffic-lights.jpg?w=300&h=240";
   private static final int PAD = 13;
   private JLabel stopLightLabel = new JLabel();
   private EnumMap<LightColor, Icon> lightIconMap = new EnumMap<LightColor, Icon>(
         LightColor.class);
   private LightColor lightColor = LightColor.RED;

   public StopLightApp() throws IOException {
      URL stopLightImgUrl = new URL(IMG_PATH);
      BufferedImage stopLightImg = ImageIO.read(stopLightImgUrl);
      for (int i = 0; i < LightColor.values().length; i++) {
         BufferedImage smlLightImg = specializedForThisImageGetSubImage(
               stopLightImg, i);
         Icon smlIcon = new ImageIcon(smlLightImg);
         lightIconMap.put(LightColor.values()[i], smlIcon);
      }
      add(stopLightLabel);
      stopLightLabel.setIcon(lightIconMap.get(lightColor));
      stopLightLabel.setText(lightColor.getName());
      stopLightLabel.setHorizontalTextPosition(SwingConstants.CENTER);
      stopLightLabel.setVerticalTextPosition(SwingConstants.BOTTOM);
      setBackground(Color.white);
      setBorder(BorderFactory.createEmptyBorder(10, 60, 10, 60));
   }

   private BufferedImage specializedForThisImageGetSubImage(
         BufferedImage stopLightImg, int i) {
      int x = PAD + (i * (stopLightImg.getWidth() - 2 * PAD)) / 3;
      int y = PAD;
      int w = (stopLightImg.getWidth() - 2 * PAD) / 3;
      int h = stopLightImg.getHeight() - 2 * PAD;
      BufferedImage smlLightImg = stopLightImg.getSubimage(x, y, w, h);
      return smlLightImg;
   }

   public void setLightColor(LightColor lightColor) {
      this.lightColor = lightColor;
      stopLightLabel.setIcon(lightIconMap.get(lightColor));
      stopLightLabel.setText(lightColor.getName());
   }

   private static void createAndShowGui() {
      try {
         final StopLightApp stopLight = new StopLightApp();
         JFrame frame = new JFrame("Stop Light App");
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         frame.getContentPane().add(stopLight);
         frame.pack();
         frame.setLocationRelativeTo(null);
         frame.setVisible(true);
         int delay = 1000;
         new Timer(delay, new ActionListener() {
            int index = 0;

            @Override
            public void actionPerformed(ActionEvent e) {
               index++;
               index %= LightColor.values().length;
               stopLight.setLightColor(LightColor.values()[index]);
            }
         }).start();
      } catch (IOException e) {
         e.printStackTrace();
      }
   }

   public static void main(String[] args) {
      SwingUtilities.invokeLater(new Runnable() {
         public void run() {
            createAndShowGui();
         }
      });
   }
}

enum LightColor {
   RED("Red"), YELLOW("Yellow"), GREEN("Green");
   private String name;

   private LightColor(String name) {
      this.name = name;
   }

   public String getName() {
      return name;
   }
}