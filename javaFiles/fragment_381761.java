private void saveToFile( BufferedImage img, File file ) throws IOException 
{
    ImageWriter writer = null;
    java.util.Iterator iter = ImageIO.getImageWritersByFormatName("jpg");

    if( iter.hasNext() )
    {
        writer = (ImageWriter)iter.next();
    }

try {
       ImageOutputStream ios = ImageIO.createImageOutputStream( file );
       writer.setOutput(ios);
       ImageWriteParam param = new JPEGImageWriteParam( java.util.Locale.getDefault() );
       param.setCompressionMode(ImageWriteParam.MODE_EXPLICIT) ;
       param.setCompressionQuality(0.98f);

       writer.write(null, new IIOImage( img, null, null ), param);
    }

    finally {
        if (ios != null) {
          try {
            ios.flush();
          }
     catch (      IOException e) {
          }
          try {
            ios.close();
          }
     catch (      IOException e) {
          }
        }
        if (writer != null) {
          writer.dispose();
        }
      } 
}