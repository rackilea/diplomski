public static final Bitmap getNewBitmap(Bitmap bmp, int circleCenterX,
int circleCenterY,int circleRadius){
    //CIRCLE COORDINATES ARE THE DISTANCE IN RESPECT OF (0,0) of the bitmap
    //, not (0,0) of the canvas itself. The circleRadius is the circle's radius.
    Bitmap temp=bmp.copy(Bitmap.Config.ARGB_8888, true);
    int[]pixels = new int[temp.getWidth()*temp.getHeight()];
    temp.getPixels(pixels,0 ,temp.getWidth(),0,0,temp.getWidth(), temp.getHeight());
    int counter=0;
    for(int i=0;i<pixels.length;i++){
        int alpha=Color.alpha(pixels[i]);
        if(alpha!=0&&!((Math.pow(counter/temp.getWidth()-circleCenterY,2.0)+
        Math.pow(counter%temp.getWidth()-circleCenterX,2.0))<Math.pow(circleRadius,2.0))){
        //if the pixel itself is not completely transparent and the pixel is NOT within range of the circle,
        //set the Alpha value of the pixel to 0.
            pixels[i]=Color.argb(0,Color.red(pixels[i]),Color.green(pixels[i]),Color.blue(pixels[i]));
        }
        counter++;
    }
    temp.setPixels(pixels,0, temp.getWidth(),0,0,temp.getWidth(),temp.getHeight());
    return temp;
}