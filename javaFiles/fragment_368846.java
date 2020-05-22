public class LabelJarSample {

  public static void main(String args[]) {
    String title = "JLabel Sample";
    JFrame frame = new JFrame(title);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    Container content = frame.getContentPane();
    content.setLayout(new GridLayout(2, 2));

    JLabel label1 = new JLabel("Text Label");
    content.add(label1);

    Image warnImage = ImageLoader.getImage(LabelJarSample.class, "Warn.gif");
    Icon warnIcon = new ImageIcon(warnImage);
    JLabel label2 = new JLabel(warnIcon);
    content.add(label2);

    JLabel label3 = new JLabel("Warning", warnIcon, JLabel.CENTER);
    content.add(label3);

    String htmlLabel = "<html><sup>HTML</sup> <sub><em>Label</em></sub><br>"
        + "<font color=\"#FF0080\"><u>Multi-line</u></font>";
    JLabel label4 = new JLabel(htmlLabel);
    content.add(label4);

    frame.setSize(300, 200);
    frame.setVisible(true);
  }
}




final class ImageLoader {

  private ImageLoader() {
  }

  public static Image getImage(Class relativeClass, String filename) {
    Image returnValue = null;
    InputStream is = relativeClass.getResourceAsStream(filename);
    if (is != null) {
      BufferedInputStream bis = new BufferedInputStream(is);
      ByteArrayOutputStream baos = new ByteArrayOutputStream();
      try {
        int ch;
        while ((ch = bis.read()) != -1) {
          baos.write(ch);
        }
        returnValue = Toolkit.getDefaultToolkit().createImage(
            baos.toByteArray());
      } catch (IOException exception) {
        System.err.println("Error loading: " + filename);
      }
    }
    return returnValue;
  }
}