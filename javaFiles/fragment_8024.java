public TextSource() {
    jp1 = new JPanel();
    tf1 = new JTextField(8);
    lb1 = new JLabel("Text Source");

    jp1.setLayout(new FlowLayout());

    jp1.add(tf1);
    jp1.add(lb1);

    jp1.setBackground(Color.GREEN);
    jp1.setVisible(true);

    tf1.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            newTextFirer(tf1.getText());
        }
    });

    JFrame yo = new JFrame();
    yo.add(jp1);
    yo.setVisible(true);
}