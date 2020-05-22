JLabel label = new JLabel();
panel.add(label);
panel.setLayout(null);
frame.add(panel);
panel.addMouseListener(new MouseAdapter() {
    public void mouseClicked(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        label.setText("X: "+x+" \t Y: "+y); // this sets the JLabel's text
        label.setBounds(x, y, label.getText().length()*2, 20);
    }
});
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.setSize(200, 200);
frame.setVisible(true);