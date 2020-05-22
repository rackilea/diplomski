public BufferedImage rotateImage(BufferedImage image, double degreesAngle) {    
    int w = image.getWidth();    
    int h = image.getHeight();    
    BufferedImage result = new BufferedImage(w, h, image.getType());  
    Graphics2D g2 = result.createGraphics();  
    g2.setColor(Color.WHITE);
    g2.fillRect(0, 0, w, h);
    g2.rotate(Math.toRadians(degreesAngle), w/2, h/2);
    g2.drawImage(image,null,0,0);  
    return result;   
}