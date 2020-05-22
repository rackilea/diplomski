import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ComboBoxTwo extends JFrame implements ItemListener {

    private static final long serialVersionUID = 1L;
    private JComboBox mainComboBox;
    private JComboBox subComboBox;

    public ComboBoxTwo() {
        String[] items = {"Select Item", "Color", "Shape", "Fruit"};
        String[] subItems1 = {"Select Color", "Red", "Blue", "Green"};
        mainComboBox = new JComboBox(items);
        mainComboBox.addItemListener(this);
        mainComboBox.addFocusListener(fcsListener);
        add(mainComboBox, BorderLayout.WEST);
        subComboBox = new JComboBox(subItems1);
        subComboBox.setPrototypeDisplayValue("XXXXXXXXXXXXXXXXXXX");
        subComboBox.addItemListener(this);
        add(subComboBox, BorderLayout.EAST);
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getStateChange() == ItemEvent.SELECTED) {
            if (e.getSource() == mainComboBox) {
                System.out.println("Source  : mainComboBox");
            } else if (e.getSource() == subComboBox) {
                System.out.println("Source  : subComboBox");
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                JFrame frame = new ComboBoxTwo();
                frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }
//
    private FocusListener fcsListener = new FocusListener() {

        @Override
        public void focusGained(FocusEvent e) {
            dumpInfo(e);
        }

        @Override
        public void focusLost(FocusEvent e) {
            dumpInfo(e);
        }

        private void dumpInfo(FocusEvent e) {
            System.out.println("Source  : " + name(e.getComponent()));
            System.out.println("Opposite : " + name(e.getOppositeComponent()));
            System.out.println("Temporary: " + e.isTemporary());
            final Component c = e.getComponent();//works for editable JComboBox too
            if (c instanceof JFormattedTextField) {
                SwingUtilities.invokeLater(new Runnable() {

                    @Override
                    public void run() {
                        ((JFormattedTextField) c).selectAll();
                    }
                });
            } else if (c instanceof JTextField) {
                SwingUtilities.invokeLater(new Runnable() {

                    @Override
                    public void run() {
                        ((JTextField) c).selectAll();
                    }
                });
            }
        }

        private String name(Component c) {
            return (c == null) ? null : c.getName();
        }
    };
}