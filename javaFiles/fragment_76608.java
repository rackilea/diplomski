public void rotateRight() {
   RGBColor[][] mirror = new RGBColor[h][w];
           for(int i = 0 ; i < h; i++){
               for(int j = 0 ; j < w; j++){
                   mirror[i][j] = pixel[j][h-i-1];
               }
           }
         pixel = mirror;
}