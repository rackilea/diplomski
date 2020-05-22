public Toolbar(){
    this.setLayout(null);
    this.setVisible(true);
    this.setPreferredSize(new Dimension(150,150));
    this.setBackground(Color.RED);

    JButton buton = new JButton("Hello!");
    buton.setBounds(40, 40, 40, 40);

    this.add(buton);
}