public byte[] extractBytes (String ImageName) throws IOException {
 // open image
 File imgPath = new File(ImageName);
 BufferedImage bufferedImage = ImageIO.read(imgPath);

 // get DataBufferBytes from Raster
 WritableRaster raster = bufferedImage .getRaster();
 DataBufferByte data   = (DataBufferByte) raster.getDataBuffer();

 return ( data.getData() );
}