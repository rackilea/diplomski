int rectSide = ...;

@Override
public void onDraw(Canvas canvas){
    int width = canvas.getWidth();
    int height = canvas.getHeight();
    canvas.drawRect(width/2f - rectSide/2f,
                    height/2f - rectSide/2f,
                    width/2f + rectSide/2f,
                    height/2f + rectSide/2f, paint);
}