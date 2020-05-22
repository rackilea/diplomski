@Override
public void paintComponent(Graphics g){
    super.paintComponent(g);
    int width = image.getWidth();
    int height = image.getHeight();
    for(int x = 0; x < width; x++){
        for(int y = 0; y < height; y++){
            int color = image.getRGB(x, y);
            int red = Colors.red(color);
            int green = Colors.green(color);
            int blue = Colors.blue(color);

            int rgb = Colors.rgba(255 - red, 255 - green, 255 - blue);
            image.setRGB(x, y, rgb);
        }
    }
    g.drawImage(image, 0, 0, width, height, Color.black, null);
}