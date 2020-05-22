void getFrame(Camera cam)
{
    ByteBuffer frameData = cam.getFrame();   //NATIVE call

    byte[] imgArray = new byte[frame.data.capacity()];
    frameData.get(imgArray); //although it seems like an array copy, this call returns very quickly
    DataBufferByte frameDataBuf = new DataBufferByte(imgArray,imgArray.length);

    //determine image sample model characteristics
    int dataType = DataBuffer.TYPE_BYTE;
    int width = cam.getFrameWidth();
    int height = cam.getFrameHeight();
    int pixelStride = cam.getPixelStride();
    int scanlineStride = cam.getScanlineStride();
    int bandOffsets = new int[] {2,1,0};  //BGR

    //create a WritableRaster with the DataBufferByte
    PixelInterleavedSampleModel pism = new PixelInterleavedSampleModel
    (
        dataType,
        width,
        height,
        pixelStride,
        scanlineStride,
        bandOffsets
    );
    WritableRaster raster = new ImgFeedWritableRaster( pism, frameDataBuf, new Point(0,0) );

    //create the BufferedImage
    ColorSpace cs = ColorSpace.getInstance(ColorSpace.CS_sRGB);
    ComponentColorModel cm = new ComponentColorModel(cs, false, false, Transparency.OPAQUE, DataBuffer.TYPE_BYTE);
    BufferedImage newImg = new BufferedImage(cm,raster,false,null);

    handleNewImage(newImg);
}