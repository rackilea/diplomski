// In the drawing class
save = new File(aster.filePath + aster.fileName + ".png");
image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
try {
    ImageIO.write(image, "png", save); 
    } catch (IOException i) {
    System.out.println("Writing has encountered an error: \n" + i); }

// In the displaying class
load = new File(aster.filePath + aster.fileName + ".png");
image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
try {
    image = ImageIO.read(load); 
    } catch (IOException i) {
    System.out.println("Reading has encountered an error: \n" + i); }
ImageIcon icon = new ImageIcon(image);
displayingJLabel.setIcon(icon);
frame.add(displayingJLabel);