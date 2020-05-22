BufferedImage image = ImageIO.read(file);
// Getting pixel color by position x=100 and y=40 
int clr=  image.getRGB(100,40); 
int  red   = (clr & 0x00ff0000) >> 16;
int  green = (clr & 0x0000ff00) >> 8;
int  blue  =  clr & 0x000000ff;