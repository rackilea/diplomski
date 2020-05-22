import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;
import javax.swing.border.*;

public class ListComponents {

    public static void main(String[] args) {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                String[] listData = {
                    "Component 1", "Component 2", "Component 3",};
                final DefaultListModel<String> model
                        = new DefaultListModel<String>();
                for (String datum : listData) {
                    model.addElement(datum);
                }
                JList list = new JList(model);
                list.setLayoutOrientation(JList.HORIZONTAL_WRAP);
                list.setVisibleRowCount(-1);
                list.setCellRenderer(new ObjectCellRenderer());

                Action addAction = new AbstractAction("Add New") {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        model.addElement("New Component");
                    }
                };
                JButton addNew = new JButton(addAction);

                JPanel ui = new JPanel(new BorderLayout(3, 3));
                ui.setBorder(new EmptyBorder(4, 4, 4, 4));
                ui.add(new JScrollPane(list), BorderLayout.CENTER);

                ui.add(addNew, BorderLayout.PAGE_START);

                JFrame f = new JFrame("Component List");
                f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                f.setContentPane(ui);
                f.pack();
                f.setLocationByPlatform(true);
                f.setVisible(true);
            }
        };
        SwingUtilities.invokeLater(r);
    }

}

class ObjectCellRenderer extends DefaultListCellRenderer {

    Border border = new EmptyBorder(20, 5, 20, 5);

    public Component getListCellRendererComponent(
            JList list,
            Object value,
            int index,
            boolean isSelected,
            boolean cellHasFocus) {
        JLabel label = (JLabel) super.getListCellRendererComponent(
                list, value, index, isSelected, cellHasFocus);
        label.setBorder(border);
        return label;
    }
}