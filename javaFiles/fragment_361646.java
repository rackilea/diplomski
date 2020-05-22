import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.RenderingHints;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import javax.swing.*;

@SuppressWarnings("serial")
public class Connect4Panel extends JPanel {
   public static final int ROWS = 6;
   public static final int COLUMNS = 7;
   public static final int DISK_WIDTH = 50;
   public static final int DISK_BORDER_WIDTH = 5;
   private static final Color FIRST_COLOR = Color.red;
   private static final Color SECOND_COLOR = Color.black;
   private Icon emptyIcon;
   private Icon firstIcon;
   private Icon secondIcon;
   private JLabel[][] diskGrid = new JLabel[ROWS][COLUMNS];
   private boolean firstTurn = true;

   public Connect4Panel() {
      emptyIcon = createIcons(new Color(0, 0, 0, 15));
      firstIcon = createIcons(FIRST_COLOR);
      secondIcon = createIcons(SECOND_COLOR);

      DiskListener diskListener = new DiskListener();
      // setBackground(Color.DARK_GRAY);
      setLayout(new GridLayout(ROWS, COLUMNS, 2, 0));
      for (int row = 0; row < diskGrid.length; row++) {
         for (int col = 0; col < diskGrid[row].length; col++) {
            JLabel disk = new JLabel(emptyIcon);
            disk.addMouseListener(diskListener);
            diskGrid[row][col] = disk;
            add(disk);
         }
      }
   }

   private Icon createIcons(Color color) {
      int width = DISK_WIDTH + 2 * DISK_BORDER_WIDTH;
      BufferedImage bImg = new BufferedImage(width, width, BufferedImage.TYPE_INT_ARGB);
      Graphics2D g2 = bImg.createGraphics();
      g2.setColor(color);
      g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
      int x = DISK_BORDER_WIDTH;
      int oWidth = DISK_WIDTH;
      g2.fillOval(x, x, oWidth, oWidth);
      g2.dispose();
      return new ImageIcon(bImg);
   }

   private class DiskListener extends MouseAdapter {
      @Override
      public void mousePressed(MouseEvent e) {
         JLabel disk = (JLabel) e.getSource();
         int selectedColumn = -1;
         for (int row = 0; row < diskGrid.length; row++) {
            for (int col = 0; col < diskGrid[row].length; col++) {
               if (disk == diskGrid[row][col]) {
                  selectedColumn = col;
               }
            }
         }

         for (int row = ROWS - 1; row >= 0; row--) {
            if (diskGrid[row][selectedColumn].getIcon() == emptyIcon) {
               Icon icon = firstTurn ? firstIcon : secondIcon;
               diskGrid[row][selectedColumn].setIcon(icon);
               firstTurn = !firstTurn;
               break;
            }
         }

         // TODO check for win
      }
   }

   private static void createAndShowGui() {
      Connect4Panel mainPanel = new Connect4Panel();

      JFrame frame = new JFrame("Connect 4 Panel");
      frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      frame.getContentPane().add(mainPanel);
      frame.pack();
      frame.setLocationByPlatform(true);
      frame.setVisible(true);

      JOptionPane.showMessageDialog(frame, "Click on panel to see how it works!");
   }

   public static void main(String[] args) {
      SwingUtilities.invokeLater(new Runnable() {
         public void run() {
            createAndShowGui();
         }
      });
   }
}