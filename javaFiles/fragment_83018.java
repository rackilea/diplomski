import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import javax.swing.AbstractCellEditor;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableColumnModel;

public class Enrolement {

    public static void main(String[] args) {
        new Enrolement();
    }

    public Enrolement() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                DefaultTableModel model = new DefaultTableModel(new Object[]{"Subject"}, 10);

                JTable tbl = new JTable(model);
                TableColumnModel columnModel = tbl.getColumnModel();
                columnModel.getColumn(0).setCellEditor(new SubjectTableCellEditor());

                tbl.setRowHeight(columnModel.getColumn(0).getCellEditor().getTableCellEditorComponent(tbl, "Astronomy/Aurora Sinistra", true, 0, 0).getPreferredSize().height);

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(new JScrollPane(tbl));
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class SubjectTableCellEditor extends AbstractCellEditor implements TableCellEditor {

        private JComboBox subject;
        private JComboBox teacher;

        private JPanel editor;

        private Map<String, String[]> subjectTeachers = new HashMap<>(25);

        public SubjectTableCellEditor() {

            subjectTeachers.put("Astronomy", new String[]{"Aurora Sinistra"});
            subjectTeachers.put("Charms", new String[]{"Filius Flitwick"});
            subjectTeachers.put("Dark Arts", new String[]{"Igor Karkaroff", "Amycus Carrow"});
            subjectTeachers.put("Defence Against the Dark Arts", new String[]{"Defence Against the Dark Arts",
                "Quirinus Quirrell",
                "Gilderoy Lockhart",
                "Remus Lupin",
                "Bartemius Crouch Jr.",
                "Dolores Umbridge",
                "Severus Snape",
                "Amycus Carrow"});
            subjectTeachers.put("Flying", new String[]{"Rolanda Hooch"});
            subjectTeachers.put("Herbology", new String[]{"Herbert Beery",
                "Pomona Sprout",
                "Neville Longbottom"});
            subjectTeachers.put("History of Magic", new String[]{"Professor Cuthbert Binns"});
            subjectTeachers.put("Potions", new String[]{"Severus Snape",
                "Horace Slughorn"});
            subjectTeachers.put("Transfiguration", new String[]{"Minerva McGonagall",
                "Albus Dumbledore"});

            subject = new JComboBox(new String[]{
                "Astronomy",
                "Charms",
                "Dark Arts",
                "Defence Against the Dark Arts",
                "Flying",
                "Herbology",
                "History of Magic",
                "Potions",
                "Transfiguration"
            });
            teacher = new JComboBox();

            editor = new JPanel(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridwidth = GridBagConstraints.REMAINDER;
            gbc.weightx = 1;
            gbc.fill = GridBagConstraints.HORIZONTAL;

            editor.add(subject, gbc);
            editor.add(teacher, gbc);

            subject.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    teacher.setModel(new DefaultComboBoxModel(subjectTeachers.get(subject.getSelectedItem())));
                }
            });

        }

        @Override
        public Object getCellEditorValue() {
            return subject.getSelectedItem() + "/" + teacher.getSelectedItem();
        }

        @Override
        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
            if (value instanceof String) {
                String parts[] = value.toString().split("/");
                subject.setSelectedItem(parts[0]);
                teacher.setSelectedItem(parts[1]);
            }
            editor.setBackground(isSelected ? table.getSelectionBackground() : table.getBackground());
            return editor;
        }
    }

}