import java.awt.*;
import java.util.*;
import javax.swing.*;

public class CustomComboBoxRenderer {
    public static void main(final String[] arguments) {
        new CustomComboBoxRenderer().launchGui();
    }

    private void launchGui() {
        final JFrame frame = new JFrame("Stack Overflow: custom combo box renderer");
        frame.setBounds(100, 100, 800, 600);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        final JComboBox<Concept> comboBox = getComboBox();
        final JLabel label = new JLabel("Please make a selection...");

        comboBox.addActionListener(actionEvent -> {
            final Object selectedItem = comboBox.getSelectedItem();
            if (selectedItem instanceof Concept)
                label.setText(((Concept) selectedItem).getValue());
        });

        final JPanel panel = new JPanel(new BorderLayout());
        panel.add(comboBox, BorderLayout.NORTH);
        panel.add(label, BorderLayout.CENTER);
        frame.getContentPane().add(panel);

        frame.setVisible(true);
    }

    private JComboBox<Concept> getComboBox() {
        final List<Concept> concepts = Arrays.asList(new Concept("label 1", "value 1"),
                                                     new Concept("label 2", "value 2"),
                                                     new Concept("label 3", "value 3"));

        final JComboBox<Concept> comboBox = new JComboBox<>(new Vector<>(concepts));

        comboBox.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(final JList<?> list,
                                                          final Object value,
                                                          final int index,
                                                          final boolean isSelected,
                                                          final boolean cellHasFocus) {
                super.getListCellRendererComponent(list, value, index, isSelected,
                                                   cellHasFocus);
                if (value instanceof Concept)
                    setText(((Concept) value).getLabel());

                return this;
            }
        });

        return comboBox;
    }
}