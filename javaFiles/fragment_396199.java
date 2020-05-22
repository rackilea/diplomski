import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

public class TestTable {

    public static void main(String[] args) {
        new TestTable();
    }

    public TestTable() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                DefaultTableModel model = new DefaultTableModel();

                final JTextField rollField = new JTextField(10);
                final JTextField nameField = new JTextField(10);
                final JTextField classField = new JTextField(10);
                final JTextField sectionField = new JTextField(10);

                JPanel details = new JPanel(new GridLayout(1, 4));
                details.add(rollField);
                details.add(nameField);
                details.add(classField);
                details.add(sectionField);

                model.setColumnIdentifiers(new String[]{"Roll No", "Name", "Class", "Section"});
                model.addRow(new String[]{"1", "Happy", "Warrior", "Inner"});
                model.addRow(new String[]{"2", "Sad", "Mage", "Outter"});
                model.addRow(new String[]{"3", "Jug Head", "Clown", "Outter space"});

                final JTable table = new JTable(model);
                table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
                    @Override
                    public void valueChanged(ListSelectionEvent e) {
                        int row = table.getSelectedRow();
                        System.out.println("Selecte table row = " + row);
                        if (row != -1) {
                            int modelRow = table.convertRowIndexToModel(row);
                            System.out.println("Selecte model row = " + row);
                            Vector data = (Vector) ((DefaultTableModel) table.getModel()).getDataVector().get(modelRow);
                            rollField.setText(data.get(0).toString());
                            nameField.setText(data.get(1).toString());
                            classField.setText(data.get(2).toString());
                            sectionField.setText(data.get(3).toString());
                        }
                    }
                });

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(details, BorderLayout.NORTH);
                frame.add(new JScrollPane(table));
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

}