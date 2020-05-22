public class Block extends JPanel{

    private int rotation;
    // if you wish to initialize it with greenBlock...
    private Image myImage = Images.greenBlock;

    public Block(){
    }

    @Override
    protected void paintComponent(Graphics g){ 
        super.paintComponent(g);    
        Graphics2D g2 = (Graphics2D) g;
        g2.drawImage(myImage, 0, 0, null);
    } 

    public void changeImage(Image img) {
        this.myImage = img;
        repaint();
    }
}