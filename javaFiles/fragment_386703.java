List<Size> allSizes = param.getSupportedPictureSizes();
Camera.Size size = allSizes.get(0); // get top size
for (int i = 0; i < allSizes.size(); i++) {
     if (allSizes.get(i).width > size.width)
       size = allSizes.get(i);
 }
//set max Picture Size
 params.setPictureSize(size.width, size.height);