public class Map extends JPanel {
    BufferedImage car1;
    BufferedImage car2;
    BufferedImage car3;

    public Map(){
        try {
            car1 = ImageIO.read(getClass().getResource("somecarimage.png"));
            car3 = ImageIO.read(getClass().getResource("somecarimage.png"));
            car3 = ImageIO.read(getClass().getResource("somecarimage.png"));
        }
    }

    protected void paintComponent(Graphics g){
        super.paintComponent(g);

        // use the drawImage method
        g.drawImage(car1, xLocation, yLocation, height, width, this);
        g.drawImage(car2, xLocation, yLocation, height, width, this);
        g.drawImage(car2, xLocation, yLocation, height, width, this);
    }
}