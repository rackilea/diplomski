package testing;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.Arrays;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JFrame;

public class JComboBoxMaster extends JFrame {

  private JComboBox generateComboBox() {
    JComboBox ddl = new JComboBox();
    List<String> items = Arrays.asList("one", "two", "three");

    for (String s : items) {
      ddl.addItem(s);
    }

    return ddl;
  }

  public static void main(String[] args) {
    JComboBoxMaster jcbm = new JComboBoxMaster();
    jcbm.setLayout(new GridBagLayout());
    jcbm.setDefaultCloseOperation(EXIT_ON_CLOSE);

    GridBagConstraints constraints = new GridBagConstraints();
    constraints.gridheight = 3;
    constraints.gridwidth = 1;
    constraints.gridx = 0;
    constraints.gridy = 0;
    JComboBox test = jcbm.generateComboBox();
    jcbm.getContentPane().add(test, constraints);

    jcbm.pack();
    jcbm.setVisible(true);

// This works
    test.addItem("four");

  }
}