import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.swing.*;

public class ImageSwap extends JPanel {
   private Map<Head, Icon> headIconMap = new HashMap<>();
   private JComboBox<Earrings> earingCombo = new JComboBox<>(Earrings.values());
   private JComboBox<Hat> hatCombo = new JComboBox<>(Hat.values());
   private JButton loadButton = new JButton(new LoadAction("Load", KeyEvent.VK_L));
   private JLabel avatarLabel = new JLabel();

   public ImageSwap() throws IOException {
      addToMap("blackleather.PNG", Earrings.NONE, Hat.BLACK_LEATHER);
      addToMap("blackleather_goldear.PNG", Earrings.GOLD, Hat.BLACK_LEATHER);
      addToMap("blackleather_silverear.PNG", Earrings.SILVER, Hat.BLACK_LEATHER);
      addToMap("captainhat.PNG", Earrings.NONE, Hat.CAPTAIN);
      addToMap("captainhat_goldear.PNG", Earrings.GOLD, Hat.CAPTAIN);
      addToMap("captainhat_silverear.PNG", Earrings.SILVER, Hat.CAPTAIN);
      addToMap("goldear.PNG", Earrings.GOLD, Hat.NONE);
      addToMap("noaccessories.PNG", Earrings.NONE, Hat.NONE);
      addToMap("silverear.PNG", Earrings.SILVER, Hat.NONE);

      avatarLabel.setIcon(headIconMap.get(new Head(Earrings.NONE, Hat.NONE)));

      JPanel buttonComboPanel = new JPanel(new GridLayout(0, 1, 0, 5));
      buttonComboPanel.add(earingCombo);
      buttonComboPanel.add(hatCombo);
      buttonComboPanel.add(loadButton);

      setLayout(new BorderLayout());
      add(avatarLabel, BorderLayout.CENTER);
      add(buttonComboPanel, BorderLayout.PAGE_END);
   }

   private void addToMap(String resourceText, Earrings earrings, Hat hat)
         throws IOException {
      BufferedImage img = ImageIO.read(getClass().getResource(resourceText));
      Icon icon = new ImageIcon(img);
      headIconMap.put(new Head(earrings, hat), icon);
   }

   private class LoadAction extends AbstractAction {
      public LoadAction(String name, int mnemonic) {
         super(name);
         putValue(MNEMONIC_KEY, mnemonic);
      }

      @Override
      public void actionPerformed(ActionEvent e) {
         Earrings selectedEarrings = (Earrings) earingCombo.getSelectedItem();
         Hat selectedHat = (Hat) hatCombo.getSelectedItem();

         if (selectedEarrings != null && selectedHat != null) {
            avatarLabel.setIcon(headIconMap.get(new Head(selectedEarrings, selectedHat)));
         }
      }
   }

   private static void createAndShowGui() {
      ImageSwap mainPanel;
      try {
         mainPanel = new ImageSwap();
         JFrame frame = new JFrame("ImageSwap");
         frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
         frame.getContentPane().add(mainPanel);
         frame.pack();
         frame.setLocationByPlatform(true);
         frame.setVisible(true);
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

class Head {
   Earrings earrings;
   Hat hat;

   public Head(Earrings earrings, Hat hat) {
      this.earrings = earrings;
      this.hat = hat;
   }

   public Earrings getEarrings() {
      return earrings;
   }

   public Hat getHat() {
      return hat;
   }

   @Override
   public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((earrings == null) ? 0 : earrings.hashCode());
      result = prime * result + ((hat == null) ? 0 : hat.hashCode());
      return result;
   }

   @Override
   public boolean equals(Object obj) {
      if (this == obj)
         return true;
      if (obj == null)
         return false;
      if (getClass() != obj.getClass())
         return false;
      Head other = (Head) obj;
      if (earrings != other.earrings)
         return false;
      if (hat != other.hat)
         return false;
      return true;
   }

}

enum Earrings {
   NONE("No Earrings"), SILVER("Silver Dangling Earrings"), GOLD(
         "Gold Dangling Earrings");
   private String text;

   private Earrings(String text) {
      this.text = text;
   }

   @Override
   public String toString() {
      return text;
   }
}

enum Hat {
   NONE("No Hat"), CAPTAIN("Captain Hat"), BLACK_LEATHER("Black Leather Hat");
   private String text;

   private Hat(String text) {
      this.text = text;
   }

   @Override
   public String toString() {
      return text;
   }
}