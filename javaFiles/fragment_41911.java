import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.*;

public class Foo003 {
   private static final int BTN_COUNT = 3;
   private static final int VERT_GAP = 10;
   private static final int EB_GAP = 5;
   private static final float TITLE_SIZE = 36f;
   private static final String TITLE_TEXT = "This is my Title";

   private static void createAndShowUI() {

      JLabel titleLabel = new JLabel(TITLE_TEXT, SwingConstants.CENTER);
      titleLabel.setFont(titleLabel.getFont().deriveFont(TITLE_SIZE));
      JPanel titlePanel = new JPanel();
      titlePanel.add(titleLabel);

      JPanel buttonPanel = new JPanel(new GridLayout(1, 0, 5, 0));
      for (int i = 0; i < BTN_COUNT; i++) {
         JButton btn = new JButton("Button " + (i + 1));
         buttonPanel.add(btn);
      }

      JTextArea textArea = new JTextArea(20, 30);

      JPanel mainPanel = new JPanel();
      mainPanel.setBorder(BorderFactory.createEmptyBorder(EB_GAP, EB_GAP, EB_GAP, EB_GAP));
      mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));
      mainPanel.add(titlePanel);
      mainPanel.add(Box.createVerticalStrut(VERT_GAP));
      mainPanel.add(buttonPanel);
      mainPanel.add(Box.createVerticalStrut(VERT_GAP));
      mainPanel.add(new JScrollPane(textArea));

      JFrame frame = new JFrame("Foo003");
      frame.getContentPane().add(mainPanel, BorderLayout.CENTER);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.pack();
      frame.setLocationRelativeTo(null);
      frame.setVisible(true);
   }

   public static void main(String[] args) {
      java.awt.EventQueue.invokeLater(new Runnable() {
         public void run() {
            createAndShowUI();
         }
      });
   }
}