public Bitmap CreateACube(Bitmap b2D){
    Bitmap result=Bitmap.createBitmap(b2D);
    /*loading sides of cube and painting texture on them*/
    Bitmap top;
    Bitmap left;
    Bitmap front;
    top=BitmapFactory.decodeResource(getResources(), R.drawable.top);
    top=CubeCreator(top, b2D,"top");
    left=BitmapFactory.decodeResource(getResources(), R.drawable.left);
    left=CubeCreator(left, b2D,"left");
    front=BitmapFactory.decodeResource(getResources(), R.drawable.front);
    front=CubeCreator(front, b2D,"front");
    Bitmap merge;
    merge=overlay(top, left);//connecting all cube sides together into one bitmap
    merge=overlay(merge, front);
    result=Bitmap.createScaledBitmap(merge, merge.getWidth()*2, merge.getHeight()*2, false); //Scaling the result, you can remove if you don't want to.
    return result;
}
private Bitmap CubeCreator(Bitmap srcBmp,Bitmap b2D,String s){
/*gets cube side bitmap, the texture bitmap, and a string of the side name*/
      int width = srcBmp.getWidth();
        int height = srcBmp.getHeight();
        int width2=b2D.getWidth();
        int height2=b2D.getHeight();
        int rows1=0;
        int rows2=0;
        Bitmap dstBitmap = Bitmap.createBitmap(width, height, Config.ARGB_8888);
        /*Running on every pixel in the cube side*/
        for (int row = 0; row < height; row++) {
            rows1=++rows1%height2; //running on every pixel on the texture and reseting it if reached the last pixel
            for (int col = 0; col < width; col++) {
                 rows2=++rows2%width2;
                int pixel = srcBmp.getPixel(col, row);
                int alpha = Color.alpha(pixel);
                int dstColor=b2D.getPixel(rows2, rows1);
                switch(s){//you can add more sides, I used 3
                case "front":{
                    float[] hsv = new float[3];
                    int color = dstColor;
                    Color.colorToHSV(color, hsv);
                    hsv[2] *= 0.8f; // giving brightness to certain sides to make it look more 3D
                    dstColor = Color.HSVToColor(hsv);
                break;
                }
                case "left":{
                    float[] hsv = new float[3];
                    int color = dstColor;
                    Color.colorToHSV(color, hsv);
                    hsv[2] *= 0.44f; 
                    dstColor = Color.HSVToColor(hsv);
                    break;
                }
                case "top":{
                    float[] hsv = new float[3];
                    int color = dstColor;
                    Color.colorToHSV(color, hsv);
                    hsv[2] *= 1.2f; 
                    dstColor = Color.HSVToColor(hsv);
                    break;
                }

                }
                int pixel2=srcBmp.getPixel(col, row);
                if(pixel2!= Color.TRANSPARENT)//checking if the current pixel of the side is not transparent
                dstBitmap.setPixel(col, row, dstColor);
                else{
                    dstBitmap.setPixel(col, row, pixel2);
                }
            }
        }

        return dstBitmap;
}
public static Bitmap overlay(Bitmap bmp1, Bitmap bmp2) {
    /*connects two bitmaps together*/
    Bitmap bmOverlay = Bitmap.createBitmap(bmp1.getWidth(), bmp1.getHeight(), bmp1.getConfig());
    Canvas canvas = new Canvas(bmOverlay);
    canvas.drawBitmap(bmp1, new Matrix(), null);
    canvas.drawBitmap(bmp2, 0, 0, null);
    return bmOverlay;
}