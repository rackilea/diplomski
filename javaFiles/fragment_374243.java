public void allblack() {
    l1.setForeground(Color.black);
    l2.setForeground(Color.black);
}

private JLabel l1,l2;
public void initialize() {

    frmDasLeiterspiel = new JFrame();
    frmDasLeiterspiel.setResizable(false);
    frmDasLeiterspiel.setTitle("Das Leiterspiel");
    frmDasLeiterspiel.setBounds(100, 100, 420, 420);
    frmDasLeiterspiel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frmDasLeiterspiel.getContentPane().setLayout(null);

    l1 = new JLabel("1");
    l1.setBackground(Color.LIGHT_GRAY);
    l1.setBounds(340, 190, 50, 50);
    l1.setHorizontalAlignment(SwingConstants.CENTER);
    frmDasLeiterspiel.getContentPane().add(l1, BorderLayout.CENTER);

    l2 = new JLabel("2");
    l2.setBackground(Color.LIGHT_GRAY);
    l2.setHorizontalAlignment(SwingConstants.CENTER);
    l2.setBounds(278, 190, 50, 50);
    frmDasLeiterspiel.getContentPane().add(l2);
    [....]
    JButton btnNewButton = new JButton("Roll the dice!");
    btnNewButton.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent arg0) {
            allblack();
        }
    });
    btnNewButton.setBounds(12, 294, 378, 25);
    frmDasLeiterspiel.getContentPane().add(btnNewButton);
    [...]
    }