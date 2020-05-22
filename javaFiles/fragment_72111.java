public double ft(int x, int y, int br, int a, int height, int width, int[][] pixelTemp, double c){
    int r;
    int g;
    int b;
    double avg;     
    double newCitrar = 0, newCitrai = 0;
    int temp;
    double f=(double)1/(double)(height*width);
    for (int i=0; i<width; i++){
        for (int j=0; j<height; j++){
            temp = pixelTemp[i][j];
//            r = (temp>>16)&0xff;
//            g = (temp>>8)&0xff;
//            b = temp&0xff;
            avg = temp; // (r+g+b)/3;
        newCitrar = newCitrar + avg*Math.cos(2*Math.PI*(((double)(i*x)/(double)width)+((double)(j*y)/(double)height)));
        newCitrai=newCitrai+avg*Math.sin(2*Math.PI*(((double)(i*x)/(double)width)+((double)(j*y)/(double)height)));
      }
    }
    newCitrar *=f;
    newCitrai *=f;
    double newCitra=Math.sqrt(newCitrar*newCitrar+newCitrai*newCitrai);
    return newCitra;
}