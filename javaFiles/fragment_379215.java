try {
  FileInputStream stream = new FileInputStream("image.psd");
  PsdImage psdFile = new PsdImage(stream);
  System.out.println("Image width: " + psdFile.getWidth());
  System.out.println("Image height: " + psdFile.getHeight());
  PsdView view = new PsdView();
  view.setPsdFile(psdFile);
  getContentPane().add(view);
} catch (IOException e) {
  System.err.println("Error reading image file image.psd: " + e);
}