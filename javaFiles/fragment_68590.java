import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ComboBoxTwo extends JFrame {

    private static final long serialVersionUID = 1L;
    private JTextField text = new JTextField(15);
    private JSpinner spinner = new JSpinner(new SpinnerNumberModel(0, 0, 15, 1));

    public ComboBoxTwo() {
        text.setText("Something selectable");
        text.addFocusListener(fcsListener);
        JFormattedTextField format = ((JSpinner.DefaultEditor) spinner.getEditor()).getTextField();
        // or JTextField tf = ((JSpinner.DefaultEditor) spinner.getEditor()).getTextField();
        format.addFocusListener(fcsListener);
        //or tf.addFocusListener(fcsListener); // depends of type for SpinnerXxxModel 
        add(text, BorderLayout.NORTH);
        add(spinner, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new ComboBoxTwo();
                frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
                frame.pack();
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
                        ((JFormattedTextField) c).setText(((JFormattedTextField) c).getText());
                        ((JFormattedTextField) c).selectAll();
                    }
                });
            } else if (c instanceof JTextField) {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        ((JTextField) c).setText(((JTextField) c).getText());
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