private static class MyJLabel extends JLabel {
    private ImageIcon img = null;

    public MyJLabel(ImageIcon img) {
        super();
        this.img = img;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(img.getImage(), 0, 0, getWidth(), getHeight(), this);
    }
}