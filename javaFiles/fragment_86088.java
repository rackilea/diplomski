while ( ( r = imageInFile.read( buff)) > 0 ) {

      byte[] realBuff = Arrays.copyOf( buff, r );

      String imageData = encodeImage(realBuff);

      ...
 }