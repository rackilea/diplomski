Clipboard clip = Toolkit.getDefaultToolkit().getSystemClipboard()
Transferable content =
    clip.getContents(null);
BufferedImage img = (BufferedImage) content.getTransferData(
    DataFlavor.imageFlavor);
ImageIO.write(img, "png", new File("/tmp/test.png"));