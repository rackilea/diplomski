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