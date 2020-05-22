import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class EditableJComboBox {

    public EditableJComboBox() {
        initComponents();
    }

    private void initComponents() {
        JFrame frame = new JFrame("Editable JComboBox");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        String labels[] = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};
        final JComboBox comboBox = new JComboBox(labels);
        comboBox.setEditable(true);

        comboBox.addActionListener(new ActionListener() {
            private boolean found = false;

            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String s = (String) comboBox.getSelectedItem();
                for (int i = 0; i < comboBox.getItemCount(); i++) {
                    if (comboBox.getItemAt(i).toString().equals(s)) {
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    System.out.println("Added: " + s);
                    comboBox.addItem(s);
                }
                found = false;
            }
        });

        frame.add(comboBox);

        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String args[]) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new EditableJComboBox();
            }
        });
    }
}