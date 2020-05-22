public void saveAsImage(){

BufferedImage image = new BufferedImage(100, 100, BufferedImage.TYPE_INT_BGR);

try {
         Graphics2D graphic = image.createGraphics();
         File output = new File("output.png");
         draw(graphic);  // actual drawing on your image
         ImageIO.write(image, "png", output);
    } catch(IOException log) {
         System.out.println(log);
    }


}