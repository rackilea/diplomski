Robot r = new Robot();

// Capture area
int width = ...
int height = ...
Rectangle area = new Rectangle(width, height);
BufferedImage image = r.createScreenCapture(area);

// Save to file
ImageIO.write(image, "png", new File("/screenshot.png"));