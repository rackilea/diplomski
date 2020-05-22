g.setColor(Color.BLACK);

//Black rectangle on the left edge
g.fillRect(x, y, rectWidth, rectHeight);
x += rectSize;

for(String image : images){
    BufferedImage bi = ImageIO.read(new File(image));
    g.drawImage(bi, x, y, null);
    x += bi.getWidth();
    //Black rectangle on the right
    g.fillRect(x, y, rectWidth, rectHeight);
    x += rectSize;
}