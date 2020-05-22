private Image resize(Image image, int width, int height) {
  Image scaled = new Image(Display.getDefault(), width, height);
  GC gc = new GC(scaled);
  gc.setAntialias(SWT.ON);
  gc.setInterpolation(SWT.HIGH);
  gc.drawImage(image, 0, 0,  image.getBounds().width, image.getBounds().height, 
  0, 0, width, height);
  gc.dispose();
  image.dispose(); // don't forget about me!
  return scaled;
  }