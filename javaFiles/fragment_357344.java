class MyPanel2 extends JPanel {

    private BufferedImage imageA;
    private BufferedImage imageB;
    private double k = 3.0;

    String IMG_URL1 = "img/upg.png";

    public MyPanel2() {

        try {
            imageA = ImageIO.read(new File(IMG_URL1));
        } catch (IOException e) {
            System.err.println("Couldn't find input file. ");
            System.exit(1);
        }

        double radius = k*imageA.getHeight();
        int xC = (int)radius, yC = (int)radius; 
        imageB = new BufferedImage(xC*2,yC, BufferedImage.TYPE_INT_ARGB);

        double r, i, j;
        for(int y = 0; y < imageB.getHeight(); y++) {
            for (int x = 0; x < imageB.getWidth(); x++) {
                r = Math.sqrt((xC-x)*(xC-x)+(yC-y)*(yC-y));
                i = (radius-r);
                j = (-k*imageA.getWidth()/2*(xC-x))/r + imageA.getWidth()/2;
                if (i>=0 && i < imageA.getHeight() && j>=0 && j < imageA.getWidth()) {
                    imageB.setRGB(x, y, imageA.getRGB((int)j, (int)i));
                }
            }
        }
        this.setPreferredSize(new Dimension(800, 600));
    }

    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2 = (Graphics2D)g;
        g2.drawImage(imageA, 0, 0, null);
        g2.drawImage(imageB, -imageA.getWidth(), 0, null);
    }
}