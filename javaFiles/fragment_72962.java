public static void main(String[] args) {
    NewJFrame1 frame = new NewJFrame1();
    frame.setLayout(new GridBagLayout());
    JPanel panel = new JPanel();
    JLabel jlabel = new JLabel("This is a label");
    jlabel.setFont(new Font("Verdana",1,20));
    panel.add(jlabel);
    panel.setBorder(new LineBorder(Color.BLACK)); // make it easy to see
    frame.add(panel, new GridBagConstraints());
    frame.setSize(400, 400);
    frame.setLocationRelativeTo(null);
    frame.setDefaultCloseOperation(NewJFrame1.EXIT_ON_CLOSE);
    frame.setVisible(true);
}