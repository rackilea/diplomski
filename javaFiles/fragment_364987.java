//createScreenCapture() returns BufferedImage which is more useful for what you are doing.

  static boolean bufferedImageEquals( BufferedImage b1, BufferedImage b2 ) {
    if ( b1 == b2 ) {return true;} // true if both are null
    if ( b1 == null || b2 == null ) { return false; }
    if ( b1.getWidth() != b2.getWidth() ) { return false; }
    if ( b1.getHeight() != b2.getHeight() ) { return false; }
    for ( int i = 0; i < b1.getWidth(); i++) {
     for ( int j = 0; j < b1.getHeight(); j++ ) {
       if ( b1.getRGB(i,j) != b2.getRGB(i,j) ) { 
           return false;
       }
      }
    }
    return true;
  }