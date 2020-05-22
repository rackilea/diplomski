class PicPanel extends JPanel{

    private BufferedImage image;
    private int w,h;
    public PicPanel(String fname){ //Pass picture's filename as a parameter.

        //reads the image
        try {
            image = ImageIO.read(getClass().getResource("/"+fname));
            w = image.getWidth();
            h = image.getHeight();

        } catch (IOException ioe) {
            System.out.println("Could not read in the pic");
            //System.exit(0);
        }

    }

    public Dimension getPreferredSize() {
        return new Dimension(w,h);
    }
    //this will draw the image
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(image,0,0,this);
    }
}