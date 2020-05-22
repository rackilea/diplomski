import javax.swing.*;

/**
* @see http://stackoverflow.com/a/11818183/522444
*/
public class VerifierEg {

    private static final String ZERO = "0.0";
    private JTextField field1 = new JTextField(ZERO, 5);
    private JTextField field2 = new JTextField(ZERO, 5);
    private JTextField resultField = new JTextField(ZERO, 10);

    private void createAndShowGui() {
        resultField.setEditable(false);
        resultField.setFocusable(false);

        JPanel mainPanel = new JPanel();
        final JTextField[] fields = {field1, field2};

        mainPanel.add(field1);
        mainPanel.add(new JLabel(" x "));
        mainPanel.add(field2);
        mainPanel.add(new JLabel(" = "));
        mainPanel.add(resultField);

        for (JTextField field : fields) {
            field.setInputVerifier(new MyInputVerifier(field));
        }

        JFrame frame = new JFrame("VerifierEg");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(mainPanel);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    private void calcProduct() {
        double d1 = Double.parseDouble(field1.getText());
        double d2 = Double.parseDouble(field2.getText());
        double prod = d1 * d2;
        resultField.setText(String.valueOf(prod));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                VerifierEg eg = new VerifierEg();
                eg.createAndShowGui();
            }
        });
    }

    /**
    * @see http://stackoverflow.com/a/11818946/230513
    */
    private class MyInputVerifier extends InputVerifier {

        private JTextField field;
        private double value;

        public MyInputVerifier(JTextField field) {
            this.field = field;
        }

        @Override
        public boolean shouldYieldFocus(JComponent input) {
            if (verify(input)) {
                field.setText(String.valueOf(value));
                calcProduct();
                return true;
            } else {
                field.setText(ZERO);
                field.selectAll();
                return false;
            }

        }

        @Override
        public boolean verify(JComponent input) {
            try {
                value = Double.parseDouble(field.getText());
                return true;
            } catch (NumberFormatException e) {
                return false;
            }
        }
    }
}