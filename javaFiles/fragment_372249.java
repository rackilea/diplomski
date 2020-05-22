public RectF myOval(float width, float height, float x, float y){
    float halfW = width/2;
    float halfH = height/2;
    return new RectF(x-halfW, y-halfH, x+halfW, y+halfH);
}

canvas.drawOval(myOval(width, height, x, y), paint);