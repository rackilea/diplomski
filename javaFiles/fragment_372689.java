// One static declaration and initialization of an BufferedImage in the drawing class
public static BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
// Drawing Code

// Accessing the image
ImageIcon icon = new ImageIcon(DrawingClass.image);
displayingJLabel.setIcon(icon);
frame.add(displayingJLabel);