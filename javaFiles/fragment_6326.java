public class MyApplication extends JFrame {

    public MyApplication() {
        setTitle("Listeners");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JTextArea txtArea = new JTextArea();
        HelloActionListener hlisten = new HelloActionListener(txtArea);
        JButton bl = new JButton("TOP");
        bl.addActionListener(hlisten);
        JButton b2 = new JButton("LEFT");
        ActionListener rightListener = e -> {
            txtArea.setText("Yes,let's go Left");
        };
        b2.addActionListener(rightListener);
        JButton b3 = new JButton("RIGHT");
        b3.addActionListener(e -> {
            txtArea.setText("Sorry, we cant go Right");
        });

        JButton b4 = new JButton("Bottom");
        b4.addActionListener(hlisten);

        add(bl, BorderLayout.PAGE_START);
        add(b2, BorderLayout.LINE_START);
        add(b3, BorderLayout.LINE_END);
        add(b4, BorderLayout.PAGE_END);
        add(txtArea, BorderLayout.CENTER);
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            JFrame frame = new MyApplication();
            frame.pack();
            frame.setVisible(true);
        });
    }

    private class HelloActionListener implements ActionListener {

        private JTextArea textArea;
        public HelloActionListener(JTextArea textArea) {
            this.textArea = textArea;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            JButton button = (JButton) e.getSource();
            textArea.setText("Hello from " + button.getText());
        }
    }
}