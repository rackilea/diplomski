import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;
import java.util.Map;

import javax.swing.*;

@SuppressWarnings("serial")
public class ComplexOptionPane extends JPanel {
   private PlayerEditorPanel playerEditorPanel = new PlayerEditorPanel();
   private JTextArea textArea = new JTextArea(12, 30);

   public ComplexOptionPane() {
      textArea.setEditable(false);
      textArea.setFocusable(false);
      textArea.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 16));
      JPanel bottomPanel = new JPanel();
      bottomPanel.add(new JButton(new AbstractAction("Get Player Information") {

         @Override
         public void actionPerformed(ActionEvent arg0) {
            int result = JOptionPane.showConfirmDialog(null, playerEditorPanel,
                  "Edit Player JOptionPane", JOptionPane.OK_CANCEL_OPTION,
                  JOptionPane.PLAIN_MESSAGE);
            if (result == JOptionPane.OK_OPTION) {
               for (PlayerEditorPanel.FieldTitle fieldTitle : PlayerEditorPanel.FieldTitle
                     .values()) {
                  textArea.append(String.format("%10s: %s%n",
                        fieldTitle.getTitle(),
                        playerEditorPanel.getFieldText(fieldTitle)));
               }
            }
         }
      }));
      setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
      setLayout(new BorderLayout(5, 5));
      add(new JScrollPane(textArea), BorderLayout.CENTER);
      add(bottomPanel, BorderLayout.PAGE_END);
   }

   private static void createAndShowGui() {
      ComplexOptionPane mainPanel = new ComplexOptionPane();

      JFrame frame = new JFrame("ComplexOptionPane");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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

@SuppressWarnings("serial")
class PlayerEditorPanel extends JPanel {
   enum FieldTitle {
      NAME("Name"), SPEED("Speed"), STRENGTH("Strength"), HEALTH("Health");
      private String title;

      private FieldTitle(String title) {
         this.title = title;
      }

      public String getTitle() {
         return title;
      }
   };

   private static final Insets WEST_INSETS = new Insets(5, 0, 5, 5);
   private static final Insets EAST_INSETS = new Insets(5, 5, 5, 0);
   private Map<FieldTitle, JTextField> fieldMap = new HashMap<FieldTitle, JTextField>();

   public PlayerEditorPanel() {
      setLayout(new GridBagLayout());
      setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createTitledBorder("Player Editor"),
            BorderFactory.createEmptyBorder(5, 5, 5, 5)));
      GridBagConstraints gbc;
      for (int i = 0; i < FieldTitle.values().length; i++) {
         FieldTitle fieldTitle = FieldTitle.values()[i];
         gbc = createGbc(0, i);
         add(new JLabel(fieldTitle.getTitle() + ":", JLabel.LEFT), gbc);
         gbc = createGbc(1, i);
         JTextField textField = new JTextField(10);
         add(textField, gbc);

         fieldMap.put(fieldTitle, textField);
      }
   }

   private GridBagConstraints createGbc(int x, int y) {
      GridBagConstraints gbc = new GridBagConstraints();
      gbc.gridx = x;
      gbc.gridy = y;
      gbc.gridwidth = 1;
      gbc.gridheight = 1;

      gbc.anchor = (x == 0) ? GridBagConstraints.WEST : GridBagConstraints.EAST;
      gbc.fill = (x == 0) ? GridBagConstraints.BOTH
            : GridBagConstraints.HORIZONTAL;

      gbc.insets = (x == 0) ? WEST_INSETS : EAST_INSETS;
      gbc.weightx = (x == 0) ? 0.1 : 1.0;
      gbc.weighty = 1.0;
      return gbc;
   }

   public String getFieldText(FieldTitle fieldTitle) {
      return fieldMap.get(fieldTitle).getText();
   }

}