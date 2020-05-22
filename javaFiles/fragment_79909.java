protected static ImageIcon createImageIcon(String path) {
//        java.net.URL imgURL = NewJApplet.class.getResource(path);

  try {
    java.net.URL imgURL = (new File(path)).toURL();
    if (imgURL != null) {
      return new ImageIcon(imgURL);
    } else {
      System.err.println("Couldn't find file: " + path);
    }
  } catch (MalformedURLException ex) {
    System.out.println(ex);
  }
  return null;
}