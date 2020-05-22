import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Demo {

      private void initGUI(){        
        Object[] items = new Object[]{"Dog","Cat","Other"};
        DefaultComboBoxModel dcbm = new DefaultComboBoxModel(items);        

        final JComboBox comboBox = new JComboBox(dcbm);
        comboBox.setPreferredSize(new Dimension(200, 20));        
        comboBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                Object selectedItem = comboBox.getSelectedItem();
                boolean editable = selectedItem instanceof String && ((String)selectedItem).equals("Other");
                comboBox.setEditable(editable);
            }
        });

        /*
         * Here you can add a new item to your JComboBox when it becomes editable
         */
        comboBox.getEditor().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object newItem = comboBox.getEditor().getItem();                  
                DefaultComboBoxModel dcbm = (DefaultComboBoxModel) comboBox.getModel();
                dcbm.addElement(newItem);
                dcbm.setSelectedItem(newItem);
            }
        });

        JPanel content = new JPanel(new FlowLayout());
        content.add(new JLabel("Test:"));
        content.add(comboBox);

        JFrame frame = new JFrame("Demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(content);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }

    public static void main(String[] args) {        
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Demo().initGUI();
            }
        });      
    }
}