public Test() {
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(400, 400);
    setLocationRelativeTo(null);
    setLayout(new BorderLayout());

    JPanel header = new JPanel();
    header.setPreferredSize(new Dimension(400, 50));
    header.setLayout(new BorderLayout());
    header.setBackground(Color.gray);

    JPanel body = new JPanel();
    body.setPreferredSize(new Dimension(400, 300));
    body.setLayout(new BorderLayout());
    body.setBackground(Color.black);

    add(header, BorderLayout.NORTH);
    add(body, BorderLayout.CENTER);
    setVisible(true);
}