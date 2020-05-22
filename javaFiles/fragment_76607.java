public void rotateLeft() {
    RGBColor[][] mirror = new RGBColor[w][h];
    if(w == h){
        for(int i = 0 ; i < h; i++){
            for(int j = 0 ; j < h; j++){
                mirror[i][j] = pixel[h-j-1][i];
            }
        }
        pixel = mirror;
    }
}