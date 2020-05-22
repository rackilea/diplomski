Clipboard clip = Toolkit.getDefaultToolkit().getSystemClipboard()

ImageIcon IMG = new ImageIcon((BufferedImage)    
clip.getData(DataFlavor.imageFlavor));
BufferedImage bImage = getBufferedImage(IMG.getImage());
ImageIO.write(bImage, "png", new File("/tmp/test.png"));