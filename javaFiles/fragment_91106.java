byte[] data = captureImage(OpenGLCanvas.getLastFocused().getViewId(), x, y);
int x_padding = x%4;
BufferedImage buff_image = new BufferedImage(x, y, BufferedImage.TYPE_INT_RGB);

int val;
for (int j = 0; j < y; j++) 
{
  for (int i = 0; i < x; i++) 
  {
    val =  ( data[(i + j*x)*3 + j*x_padding + 2]& 0xff) + 
           ((data[(i + j*x)*3 + j*x_padding + 1]& 0xff) << 8) +
           ((data[(i + j*x)*3 + j*x_padding + 0]& 0xff) << 16);
    buff_image.setRGB(i, j, val);
  }
}

//save the BufferedImage as a jpeg
try
{
  File file = new File(file_name);
  FileOutputStream out = new FileOutputStream(file);

  JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
  JPEGEncodeParam param = encoder.getDefaultJPEGEncodeParam(buff_image);
  param.setQuality(1.0f, false);
  encoder.setJPEGEncodeParam(param);
  encoder.encode(buff_image);
  out.close();
}