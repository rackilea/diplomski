final Image image = new ImageIcon("C:/images/image.png").getImage();
JPanel panel = new JPanel() {
    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(imageToPaint, 
            (desired x location), (desired y location), null);
    }
};