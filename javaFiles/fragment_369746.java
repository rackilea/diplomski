// Step 1 ) get old image
BufferedImage img = null;
try {
    img = (BufferedImage) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.imageFlavor);
} catch (UnsupportedFlavorException ufe) {
    ufe.printStackTrace();
} catch (IOException ioe) {
    ioe.printStackTrace();
}