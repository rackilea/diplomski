int[] myImage = getGreyscaleIntArray();

BufferedImage im = new BufferedImage(width,height,BufferedImage.TYPE_BYTE_GRAY);
WritableRaster raster = im.getRaster();
for(int h=0;h<height;h++)
{
    for(int w=0;w<width;w++)
    {
        raster.setSample(w,h,0, myImage[h * width + w]); 
    }
}

ByteArrayOutputStream myJpg = new ByteArrayOutputStream();
javax.imageio.ImageIO.write(im, "jpg", myJpg);