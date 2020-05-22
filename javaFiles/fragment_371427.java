Image source; // the image to be copied    
source = Image.createImage(...);    
Image copy = Image
    .createImage(source.getWidth(), source.getHeight());        
Graphics g = copy.getGraphics();    
g.drawImage(source, 0, 0, TOP|LEFT);