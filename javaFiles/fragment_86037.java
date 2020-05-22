public class Second extends JFrame {

    JButton btn;
    JTextField jtf = new JTextField(16);
    JEditorPane ep;

    Second() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        btn = new JButton("Send above Text.");
        setSize(new Dimension(200, 200));
        btn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
               ep = First.ep;
               ep.setText(jtf.getText());
               ep.setForeground(Color.red);
            }

        });
        this.setLayout(new FlowLayout());
        add(jtf);
        add(btn);
        setVisible(true);
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            First so;

            @Override
            public void run() {
                new Second();
                so = new First();
            }
        });
    }
}