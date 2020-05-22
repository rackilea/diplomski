BufferedImage bim=new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
int[] pix=new int[w*h];
for(i=0; i<pix.length; i++) pix[i]=(p[i%w][i/w].getBlue()<<16)|(p[i%w][i/w].getBlue()<<8)|p[i%w][i/w].getBlue()|0xff000000;
bim.setRGB(0, 0, w, h, pix, o, w);

try {
ImageIO.write(bim, "png", new File(path+".png"));
} catch (IOException ex) { ex.printStackTrace(); }