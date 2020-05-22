@Override
public void paintComponent(Graphics g){
    BufferedImage image = new BufferedImage(this.size.width, this.size.height, BufferedImage.TYPE_INT_RGB);
    Graphics bgr = image.getGraphics(); 
    for(Tile t : this.tiles){
        t.draw(bgr);
    }   
    super(bgr);
    g.drawImage(image, 0, 0, null);
    bgr.dispose();      
    image = null;
}