BufferedImage img=new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
for(int r=0; r<height; r++)
for(int c=0; c<width; c++)
{
  int index=r*width+c;
  int red=colors[index] & 0xFF;
  int green=colors[index+1] & 0xFF;
  int blue=colors[index+2] & 0xFF;
  int rgb = (red << 16) | (green << 8) | blue;
  img.setRGB(c, r, rgb);
}