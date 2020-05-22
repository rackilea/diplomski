import java.awt.*;
import java.util.HashMap;
import java.util.Map;

import javax.swing.*;

import com.roots.map.MapPanel.ControlPanel;

public class ComplexDialog extends JPanel {
   public static final String[] COMBO_LABELS = { "Nombre 1",
         "Identificacion 1", "Fecha 1", "Empresa 1", "Nombre 2",
         "Identificacion 2", "Fecha 2", "Empresa 2", "Nombre 3",
         "Identificacion 3", "Fecha 3", "Empresa 3", "Nombre 4",
         "Identificacion 4", "Fecha 4", "Empresa 4", "Nombre 5",
         "Identificacion 5", "Fecha 5", "Empresa 5", "Nombre 6",
         "Identificacion 6", "Fecha 6", "Empresa 6", "Nombre 7",
         "Identificacion 7", "Fecha 7", "Empresa 7" };
   public static final String[] COMBO_ITEMS = { "January", "February", "March",
         "April", "May", "June", "July", "August", "September", "October",
         "November", "December" };
   private JTextArea textarea = new JTextArea(15, 30);
   private Map<String, JComboBox> comboMap = new HashMap<String, JComboBox>();

   public ComplexDialog() {
      textarea.setLineWrap(true);
      textarea.setWrapStyleWord(true);
      for (int i = 0; i < 100; i++) {
         textarea.append("This is a really large text. ");
      }

      JPanel comboPanel = new JPanel(new GridBagLayout());
      for (int i = 0; i < COMBO_LABELS.length; i++) {
         addToComboPanel(comboPanel, COMBO_LABELS[i], i);
      }

      int eb = 5;
      setBorder(BorderFactory.createEmptyBorder(eb, eb, eb, eb));
      setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
      add(new JScrollPane(textarea));
      add(Box.createVerticalStrut(5));
      JScrollPane comboPanelScroll = new JScrollPane(comboPanel);
      add(comboPanelScroll);

      comboPanelScroll.getViewport().setPreferredSize(
            textarea.getPreferredSize());
   }

   private void addToComboPanel(JPanel comboPanel, String labelText, int index) {
      GridBagConstraints gbc = new GridBagConstraints(0, index, 1, 1, 0.2, 1.0,
            GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(0, 0,
                  0, 5), 0, 0);
      comboPanel.add(new JLabel(labelText, SwingConstants.RIGHT), gbc);

      gbc = new GridBagConstraints(1, index, 1, 1, 1.0, 1.0,
            GridBagConstraints.EAST, GridBagConstraints.HORIZONTAL, new Insets(
                  0, 0, 0, 0), 0, 0);
      JComboBox combo = new JComboBox(COMBO_ITEMS);
      comboMap.put(labelText, combo);
      comboPanel.add(combo, gbc);

   }

   public String getComboChoice(String key) {
      JComboBox combo = comboMap.get(key);
      if (combo != null) {
         return combo.getSelectedItem().toString();
      } else {
         return "";
      }
   }

   public String getTextAreaText() {
      return textarea.getText();
   }

   public int showDialog() {
      return JOptionPane.showOptionDialog(null, this, "Sirena",
            JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null,
            new String[] { "Aceptar", "Cancelar" }, "Aceptar");
   }

   private static void createAndShowGui() {
      ComplexDialog dlg = new ComplexDialog();
      int response = dlg.showDialog();
      if (response == 0) {
         System.out.println("JTextArea's text is:");
         System.err.println(dlg.getTextAreaText());

         System.out.println("Combo box selections are: ");
         for (String comboLabel : COMBO_LABELS) {

            System.out.printf("%20s: %s%n", comboLabel, dlg.getComboChoice(comboLabel));
         }
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