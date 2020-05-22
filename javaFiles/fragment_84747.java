import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Test extends JFrame {

    public Test() {

        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.setRowCount(2);
        tableModel.setColumnCount(2);
        tableModel.setValueAt("Foo", 0, 0);
        final JTable t = new JTable(tableModel);

        JPanel comp = new JPanel(new BorderLayout());
        getContentPane().add(comp);

        comp.add(t, BorderLayout.CENTER);
        JButton edit = new JButton("Edit");
        edit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                t.editCellAt(0, 0);
            }
        });
        comp.add(edit, BorderLayout.SOUTH);

        pack();
        setVisible(true);

    }

    public static void main(String[] args) {
        new Test();
    }
}