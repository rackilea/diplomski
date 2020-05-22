public void showFrame() {
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setPreferredSize(new Dimension(500, 500));
    this.getContentPane().setBackground(Color.yellow);
    JPanel p = new JPanel();
    p.setPreferredSize(new Dimension(400, 400));
    p.setBackground(Color.red);
    Border border = BorderFactory.createLineBorder(Color.blue, 10);
    border.isBorderOpaque();
    p.setBorder(border);
    this.add(p, BorderLayout.NORTH);
    this.pack();
    this.setVisible(true);
}

public static void main(String[] args) {
    new DifferentColor().showFrame();
}