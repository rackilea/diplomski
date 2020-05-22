public class Base extends JFrame {

    public Base() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        setBounds(100, 100, 150, 178);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        JButton btnNoweZamwienie = new JButton("Nowe zam\u00F3wienie");
        btnNoweZamwienie.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {

                NewOrder no = new NewOrder();    //rewrite your code accordingly; make New Order extend JFrame
                no.main(null);
            }
        });
        btnNoweZamwienie.setBounds(8, 22, 129, 23);
        getContentPane().add(btnNoweZamwienie);

        JButton btnListaZamwie = new JButton("Lista zam\u00F3wie\u0144");
        btnListaZamwie.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {

                List list = new List();   //rewrite your code accordingly; make List extend JFrame
                list.main(null);
            }
        });
        btnListaZamwie.setBounds(8, 56, 129, 23);
        getContentPane().add(btnListaZamwie);

        JButton btnWyjcie = new JButton("Wyj\u015Bcie");
        btnWyjcie.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {

                dispose();
            }
        });
        btnWyjcie.setBounds(8, 124, 129, 23);
        getContentPane().add(btnWyjcie);

        JButton button = new JButton("Lista zam\u00F3wie\u0144");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                Archives arch = new Archives();  //rewrite your code accordingly; make Archives extend JFrame
                arch.main(null);
            }
        });
        button.setBounds(8, 90, 129, 23);
        getContentPane().add(button);
    }
}