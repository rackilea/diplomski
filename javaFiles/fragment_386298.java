// screenRect is a Rectangle the contains your "character" 
// + however many images around your character that you desire
BufferedImage img = robot.createScreenCapture(screenRect);
int[] imgData = ((DataBufferInt)img.getRaster().getDataBuffer()).getData();

// now that you've got the image ints, you can analyze them as you wish.
// All I've done below is get rid of the alpha value and display the ints.
for (int i = 0; i < screenRect.height; i++) {
  for (int j = 0; j < screenRect.width; j++) {
    int index = i * screenRect.width + j;
    int imgValue = imgData[index] & 0xffffff;
    System.out.printf("%06x ", imgValue );
  }
  System.out.println();
}