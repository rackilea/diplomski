import java.awt.BorderLayout;
import java.awt.Component;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JRadioButton;
import javax.swing.ListCellRenderer;
import javax.swing.SwingUtilities;

public class JListJRadioButtonRenderer extends JFrame {
    public JListJRadioButtonRenderer() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addList();
        setSize(300, 300);
        setLocationRelativeTo(null);
    }

    private void addList() {
        JList<JRadioButton> list = new JList<>();
        DefaultListModel<JRadioButton> model = new DefaultListModel<>();
        // Add the custom renderer.
        list.setCellRenderer(new ListCellRenderer<JRadioButton>() {

            @Override
            public Component getListCellRendererComponent(JList<? extends JRadioButton> list, JRadioButton value,
                    int index, boolean isSelected, boolean cellHasFocus) {
                // Fix background for selected cells.
                value.setBackground(isSelected ? list.getSelectionBackground() : null);
                // Select the JRadioButton too since it is selected in the list.
                value.setSelected(isSelected);
                return value;
            }
        });
        list.setModel(model);
        JRadioButton stackButton = new JRadioButton("Hello Stack");
        JRadioButton overButton = new JRadioButton("Hello Over");
        JRadioButton flowButton = new JRadioButton("Hello Flow");
        model.addElement(stackButton);
        model.addElement(overButton);
        model.addElement(flowButton);
        getContentPane().add(list);

        JButton printSelected = new JButton("Print selected");
        printSelected.addActionListener(e -> {
            List<JRadioButton> selectedButtons = list.getSelectedValuesList();
            for (JRadioButton r : selectedButtons)
                System.out.println(r.getText());
        });
        getContentPane().add(printSelected, BorderLayout.PAGE_END);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new JListJRadioButtonRenderer().setVisible(true));
    }
}