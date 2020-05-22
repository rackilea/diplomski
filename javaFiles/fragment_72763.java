import javax.swing.event.*;
import javax.swing.*;

class TestList {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                final String[] items = {"item1", "item2", "item1"};
                final JList list = new JList(items);
                final JTextField output = new JTextField(15);
                JPanel gui = new JPanel();
                gui.add(list);
                gui.add(output);
                list.addListSelectionListener(new ListSelectionListener(){
                    public void valueChanged(ListSelectionEvent lse) {
                        int index = list.getSelectedIndex();
                        String outputText =
                            "Index: " +
                            index +
                            "  Value: " +
                            items[index];
                        output.setText(outputText);

                    }
                });
                JOptionPane.showMessageDialog(null, gui);
            }
        });
    }
}