public static void overlayImage(Mat background,Mat foreground,Mat output, Point location){

  background.copyTo(output);

  for(int y = (int) Math.max(location.y , 0); y < background.rows(); ++y){

   int fY = (int) (y - location.y);

   if(fY >= foreground.rows())
          break;

      for(int x = (int) Math.max(location.x, 0); x < background.cols(); ++x){
          int fX = (int) (x - location.x);
          if(fX >= foreground.cols()){
           break;
          }

           double opacity;
           double[] finalPixelValue = new double[4];

           opacity = foreground.get(fY , fX)[3];

           finalPixelValue[0] = background.get(y, x)[0];
           finalPixelValue[1] = background.get(y, x)[1];
           finalPixelValue[2] = background.get(y, x)[2];
           finalPixelValue[3] = background.get(y, x)[3];

           for(int c = 0;  c < output.channels(); ++c){
               if(opacity > 0){
                   double foregroundPx =  foreground.get(fY, fX)[c];
                   double backgroundPx =  background.get(y, x)[c];

                   float fOpacity = (float) (opacity / 255);
                   finalPixelValue[c] = ((backgroundPx * ( 1.0 - fOpacity)) + (foregroundPx * fOpacity));
                   if(c==3){
                       finalPixelValue[c] = foreground.get(fY,fX)[3];
                   }
               }
           }
           output.put(y, x,finalPixelValue);
      }
  } 
}