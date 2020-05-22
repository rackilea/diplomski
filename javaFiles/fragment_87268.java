WritableRaster raster = image.getRaster();

for(int h=0;h<height;h++) {
    for(int w=0;w<width;w++) {
        int colour = 127;
      raster.setSample(w,h,0,colour); 
   }
}