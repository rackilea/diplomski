Image selectedImage = new ImageIcon([...]).getImage();

BufferedImage img = new BufferedImage(selectedImage.getWidth(null), selectedImage.getHeight(null), BufferedImage.TYPE_INT_ARGB);
Graphics2D g = img.createGraphics();
g.drawImage(selectedImage, 0, 0, null);
g.dispose();

int transparency = 127; 
int colorMask = 0x00FFFFFF; 
int alphaShift = 24;
for(int y = 0; y < img.getHeight(); y++)
    for(int x = 0; x < img.getWidth(); x++)
        img.setRGB(x, y, (img.getRGB(x, y) & colorMask) | (transparency << alphaShift));

selectedImage = img;