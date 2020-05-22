while (keepOnAnimating) {
   BufferedImage bi = vFrames.elementAt(0);
   if (bi != null) {
      // This only repaints area of image rect
      // Prevents lots of repaints from happening in rootpane behind glasspane.
      int x = getWidth() / 2 - bi.getWidth() / 2;
      int y = getHeight() / 2 - bi.getHeight() / 2;
      jc.repaint(x, y, bi.getWidth(), bi.getHeight());
  } else {
     jc.repaint();
  }
  ...
}