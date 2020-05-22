File f = new File("/path/imagefile.jpg");

    //Find a suitable ImageReader
    Iterator readers = ImageIO.getImageReadersByFormatName("JPEG");
    ImageReader reader = null;
    while(readers.hasNext()) {
        reader = (ImageReader)readers.next();
        if(reader.canReadRaster()) {
            break;
        }
    }

    //Stream the image file (the original CMYK image)
    ImageInputStream input =   ImageIO.createImageInputStream(f); 
    reader.setInput(input); 

    //Read the image raster
    Raster raster = reader.readRaster(0, null); 

    //Create a new RGB image
    BufferedImage bi = new BufferedImage(raster.getWidth(), raster.getHeight(), 
    BufferedImage.TYPE_4BYTE_ABGR); 

    //Fill the new image with the old raster
    bi.getRaster().setRect(raster);