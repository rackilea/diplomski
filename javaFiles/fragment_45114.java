public static void saveImage(BufferedImage im) {
  JFileChooser fc = new JFileChooser();
  FileNameExtensionFilter filter = new FileNameExtensionFilter("jpg", ".jpg");
  fc.setAcceptAllFileFilterUsed(false);
  fc.setFileFilter(filter);
  int ret = fc.showSaveDialog(null);
  File f = fc.getSelectedFile();

  if (ret == JFileChooser.APPROVE_OPTION) {

    try {
      if(!f.getName().endsWith(".jpg"))
      {
        String name = f.getAbsolutePath() + ".jpg";
        f = new File( name );
      }

      ImageIO.write(im, "jpg", f);
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

  }
}