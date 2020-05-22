URL url = new URL("https://www.google.com.pk/images/srpr/logo4w.png");
 URLConnection conn = url.openConnection();

  // now you get the content length
 int contentLength = conn.getContentLength();
 // you can check size here using contentLength

 InputStream in = conn.getInputStream();
 BufferedImage    image = ImageIO.read(in);
  // you can get size  dimesion      
  int width          = image.getWidth();
  int height         = image.getHeight();