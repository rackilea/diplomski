import java.awt.*;
import javax.swing.*;

public class GridBagTest {
   public static void main(String[] args) {
      JPanel panel = new JPanel(new GridBagLayout());

      JTextArea textarea = new JTextArea(5, 30);
      JScrollPane scrollpane = new JScrollPane(textarea);

      JButton btn = new JButton("Foo");

      JLabel label = new JLabel("Bar");
      label.setBorder(BorderFactory.createTitledBorder("Bar"));

      GridBagConstraints gbc = new GridBagConstraints();
      gbc.fill = GridBagConstraints.BOTH;
      gbc.gridheight = 1;
      gbc.gridwidth = 1;
      gbc.gridx = 0;
      gbc.gridy = 0;
      gbc.weightx = 1.0;
      gbc.weighty = 1.0;

      panel.add(scrollpane, gbc);

      gbc.gridx = 1;
      panel.add(btn, gbc);

      gbc.gridx = 2;
      panel.add(label, gbc);

      // **** comment or uncomment the lines below
      // setSizes(btn, scrollpane);
      // setSizes(label, scrollpane);

      JFrame frame = new JFrame("GBC Test");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().add(panel);
      frame.pack();
      frame.setLocationRelativeTo(null);
      frame.setVisible(true);

   }

   private static void setSizes(Component changeComponent,
         Component templateComponent) {
      changeComponent.setPreferredSize(templateComponent.getPreferredSize());
      changeComponent.setMaximumSize(templateComponent.getMaximumSize());
      changeComponent.setMinimumSize(templateComponent.getMinimumSize());
   }
}