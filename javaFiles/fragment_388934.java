BufferedImage img = new BufferedImage(100, 100, BufferedImage.TYPE_3BYTE_BGR);
// If we swap the type, what we put in our for loop will vary greatly
DataBufferByte dbb = ((DataBufferByte)img.getRaster().getDataBuffer());
byte[] bytes = dbb.getData();
for (int i = 0; i < bytes.length; i++) {
  // modify byte array here with bytes[i];
}
try {
  SampleModel sampleModel = new ComponentSampleModel(DataBuffer.TYPE_BYTE, 100, 100, 3, 100*3, new int[]{2, 1, 0});
  DataBuffer dataBuffer = new DataBufferByte(bytes, bytes.length);
  Raster raster = Raster.createRaster(sampleModel, dataBuffer, null);
  img.setData(raster);
} catch stuff......