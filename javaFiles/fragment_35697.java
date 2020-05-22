public class App {
    private B _b;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                App app = new App();
                app.run();
            }
        });
    }

    void run() {
        _b = new B();
        _b.getMainButton().addActionListener(new MainButtonListener());
        _b.setVisible(true);
    }

    private void handleMainButtonClicked() {
        String mainText = _b.getMainTextArea().getText();
        System.out.println("Button clicked; main text = " + mainText);
    }

    public class MainButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            handleMainButtonClicked();
        }
    }
}

public class B extends JFrame {
    private JPanel _contentPane;
    private JTextArea _jTextArea;
    private JButton _jButton;

    public B() {
        initComponents();
    }

    private void initComponents() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
        _contentPane = new JPanel();
        setContentPane(_contentPane);

        _jTextArea = new JTextArea();
        _contentPane.add(_jTextArea, BorderLayout.CENTER);

        _jButton = new JButton("My Button");
        _contentPane.add(_jButton, BorderLayout.SOUTH);
    }

    public JButton getMainButton() {
        return _jButton;
    }

    public JTextComponent getMainTextArea() {
        return _jTextArea;
    }
}