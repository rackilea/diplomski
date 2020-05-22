ByteArrayOutputStream  byteOutput = new ByteArrayOutputStream();

ImageIO.write( SwingFXUtils.fromFXImage( writableImage, null ), "png", byteOutput );

InputStream myInputStream = new ByteArrayInputStream(byteOutput.toByteArray()); 

//setting the image
ImageView imageView = new ImageView(new Image(myInputStream));