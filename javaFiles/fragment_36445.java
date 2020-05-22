public class Jf53136132 extends JFrame {

    private static final long serialVersionUID = -3336501835025139522L;

    private JPanel contentPane;



    public Jf53136132() {
        setTitle("Jf53136132");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        JPanel panel = new JPanel();
        contentPane.add(panel, BorderLayout.CENTER);

        JButton btnInvokeJoptionpane = new JButton("set some text on label");
        panel.add(btnInvokeJoptionpane);

        JLabel lblx = new JLabel("-x-");
        panel.add(lblx);

        getNewTextForLabel(lblx);

        btnInvokeJoptionpane.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                getNewTextForLabel(lblx);
            }
        });
    }



    private void getNewTextForLabel(JLabel label) {
        String inputText = JOptionPane.showInputDialog("Enter the text for the label");
        System.out.println("you entered <" + inputText + ">");
        if (inputText != null && !inputText.trim().isEmpty()) {
            label.setText(inputText);
        }
    }

}