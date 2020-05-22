import javax.swing.*;
import java.awt.*;
import javax.swing.border.Border;

class HelloWorldSwing {
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(
                UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {}

        Runnable guiCreator = new Runnable() {
            public void run() {
                JFrame fenster = new JFrame("Hallo Welt mit Swing");
                fenster.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                SpinnerNumberModel model = new SpinnerNumberModel(1,1,9,1);
                JSpinner spinner = new JSpinner(model);

                JFormattedTextField textField = ((JSpinner.DefaultEditor)spinner.getEditor()).getTextField();
                textField.setOpaque(true);
                // textField.setBackground(Color.);

                spinner.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 0));

                spinner.setUI(new javax.swing.plaf.basic.BasicSpinnerUI() {
                    protected Component createNextButton() {
                        Component c = new JButton();
                        c.setPreferredSize(new Dimension(9, 0));
                        c.setVisible(false);
                        return c;
                    }

                    protected Component createPreviousButton() {
                        Component c = new JButton();
                        c.setPreferredSize(new Dimension(9, 0));
                         c.setVisible(false);
                        return c;
                    }
                });
                spinner.setBackground(Color.LIGHT_GRAY);
                fenster.setLayout( new FlowLayout() );
                fenster.add(spinner);

                fenster.setSize(300, 200);
                fenster.setVisible(true);
            }
        };

        SwingUtilities.invokeLater(guiCreator);
    }
}