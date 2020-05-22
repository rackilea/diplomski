public void render2(int xPos, int yPos, double angle, BitMap data){
   double angle2 = Math.toRadians(angle);
   angle = angle2;
   int w = data.getWidth();
   int h  = data.getHeight();
   int size =  (int) (Math.sqrt(w * w + h * h));
   BitMap newBitMap = new BitMap(size, size);
   int xCenter = w / 2;
   int yCenter = h / 2;
   final int halfSize = size / 2;
   for(int y = 0; y < size; y++){
       for(int x = 0; x < size; x++){
          int samplePointX = x - halfSize;
          int samplePointY = y - halfSize;

          int xData, yData;
          xData = (int)(samplePointX * -Math.cos(angle) + samplePointY * Math.sin(angle));
          yData = (int)(samplePointX * -Math.sin(angle) - samplePointY * Math.cos(angle));
          xData += xCenter;
          yData += yCenter;
          if(!(xData >= 0 && xData < w)){
             continue;
          }
          if(!(yData >= 0 && yData < h)){
             continue;
          }
          if((x) + (y) * size > size * size){
             continue;
          }
          screenPixels.setValue(x, y, data.getValue(xData, yData));
       }
   }