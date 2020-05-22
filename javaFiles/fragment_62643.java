class Background extends JPanel {

    Image backgroundPic;

    public Background() {
        ImageIcon backgroundIcon=new ImageIcon("E:/eclipse/EL/backgroundPicture.jpg");
        backgroundPic=backgroundIcon.getImage();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2D=(Graphics2D) g;
        g2D.drawImage(backgroundPic,10,10,this);
    }
}