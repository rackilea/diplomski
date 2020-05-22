JLabel myLabel = new JLabel(imageOne);
myLabel.addMouseListener(new MouseAdaper() {
    public void mousePressed(MouseEvent e) {
        ImageIcon image2 = new ImageIcon("image2.png");
        myLabel.setIcon(image2);
    }
});