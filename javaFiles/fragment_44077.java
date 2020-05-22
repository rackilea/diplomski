import java.awt.Color;
import java.awt.Component;
import java.awt.Dialog.ModalityType;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.*;

public class DialogExample extends JPanel {
   private static final int COLUMN_COUNT = 10;
   private static final int I_GAP = 3;
   public static final String BKG_IMG_PATH = "http://upload.wikimedia.org/wikipedia/commons/"
         + "thumb/9/92/Camels_in_Jordan_valley_%284568207363%29.jpg/800px-Camels_in_Jordan_valley_"
         + "%284568207363%29.jpg";

   private BufferedImage backgrndImage;
   private JTextField userNameField = new JTextField();
   private JPasswordField passwordField = new JPasswordField();
   private JPanel mainPanel = new JPanel(new GridBagLayout());
   private JButton okButton = new JButton("OK");
   private JButton cancelButton = new JButton("Cancel");

   public DialogExample(BufferedImage backgrndImage) {
      this.backgrndImage = backgrndImage;
      userNameField.setColumns(COLUMN_COUNT);
      passwordField.setColumns(COLUMN_COUNT);

      JPanel btnPanel = new JPanel(new GridLayout(1, 0, 5, 5));
      btnPanel.setOpaque(false);
      btnPanel.add(okButton);
      btnPanel.add(cancelButton);

      GridBagConstraints gbc = getGbc(0, 0, GridBagConstraints.BOTH);
      mainPanel.add(createLabel("User Name", Color.white), gbc);
      gbc = getGbc(1, 0, GridBagConstraints.HORIZONTAL);
      mainPanel.add(userNameField, gbc);
      gbc = getGbc(0, 1, GridBagConstraints.BOTH);
      mainPanel.add(createLabel("Password:", Color.white), gbc);
      gbc = getGbc(1, 1, GridBagConstraints.HORIZONTAL);
      mainPanel.add(passwordField, gbc);
      gbc = getGbc(0, 2, GridBagConstraints.BOTH, 2, 1);
      mainPanel.add(btnPanel, gbc);

      mainPanel.setOpaque(false);
      add(mainPanel);
   }

   private JLabel createLabel(String text, Color color) {
      JLabel label = new JLabel(text);
      label.setForeground(color);
      return label;
   }

   @Override
   protected void paintComponent(Graphics g) {
      super.paintComponent(g);
      if (backgrndImage != null) {
         g.drawImage(backgrndImage, 0, 0, this);
      }
   }

   @Override
   public Dimension getPreferredSize() {
      if (isPreferredSizeSet() || backgrndImage == null) {
         return super.getPreferredSize();
      }
      int imgW = backgrndImage.getWidth();
      int imgH = backgrndImage.getHeight();
      return new Dimension(imgW, imgH);
   }

   public static GridBagConstraints getGbc(int x, int y, int fill) {
      GridBagConstraints gbc = new GridBagConstraints();
      gbc.gridx = x;
      gbc.gridy = y;
      gbc.gridwidth = 1;
      gbc.gridheight = 1;
      gbc.weightx = 1.0;
      gbc.weighty = 1.0;
      gbc.insets = new Insets(I_GAP, I_GAP, I_GAP, I_GAP);
      gbc.fill = fill;

      return gbc;
   }

   public static GridBagConstraints getGbc(int x, int y, int fill, int width,
         int height) {
      GridBagConstraints gbc = getGbc(x, y, fill);
      gbc.gridwidth = width;
      gbc.gridheight = height;

      return gbc;
   }

   private static void createAndShowGui() throws IOException {
      final JFrame frame = new JFrame("Frame");

      final JDialog dialog = new JDialog(frame, "User Sign-In", ModalityType.APPLICATION_MODAL);
      URL imgUrl = new URL(BKG_IMG_PATH);
      BufferedImage img = ImageIO.read(imgUrl);
      final DialogExample dlgExample = new DialogExample(img);
      dialog.add(dlgExample);
      dialog.pack();

      JPanel mainPanel = new JPanel();
      mainPanel.add(new JButton(new AbstractAction("Please Press Me!") {

         @Override
         public void actionPerformed(ActionEvent e) {
            dialog.setVisible(true);
         }
      }));
      mainPanel.setPreferredSize(new Dimension(800, 650));

      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().add(mainPanel);
      frame.pack();
      frame.setLocationRelativeTo(null);
      frame.setVisible(true);
   }

   public static void main(String[] args) {
      SwingUtilities.invokeLater(new Runnable() {
         public void run() {
            try {
               createAndShowGui();
            } catch (IOException e) {
               e.printStackTrace();
            }
         }
      });
   }
}