public class Main extends JFrame {
    private JTextField textField1 = new JTextField();
    private JTextField textField2 = new JTextField();

    public Main() {
        setSize(200,200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(textField1, BorderLayout.NORTH);
        add(textField2, BorderLayout.SOUTH);
        textField1.setInputVerifier(fieldVerifier);
    }

    InputVerifier fieldVerifier = new InputVerifier() {
        @Override
        public boolean verify(JComponent input) {
            JTextField temp = (JTextField)input;
            try {
                int number = Integer.parseInt(temp.getText());
                return true;
            }
            catch(NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "You MUST input only numbers!");
            }
            return false;
        }
    };

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }
}