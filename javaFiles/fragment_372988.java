public class DrawView extends View {
Paint paint = new Paint();
float x_touch = -1;
float y_touch = -1;
public DrawView(Context context) {
    super(context);
    super.setWillNotDraw(false);
    paint.setColor(Color.BLACK);
}
@Override
public void onDraw(Canvas canvas) {
    super.onDraw(canvas);
    Display mdisp = ((WindowManager) getContext().getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();
    Point mdispSize = new Point();
    mdisp.getSize(mdispSize);
    int maxX = mdispSize.x;
    int maxY = mdispSize.y;
    canvas.drawLine(maxX/3, 0, maxX/3, maxY, paint);
    canvas.drawLine(maxX*2/3, 0, maxX*2/3, maxY, paint);
    canvas.drawLine(0, maxY/3, maxX, maxY/3, paint);
    canvas.drawLine(0, maxY*2/3, maxX, maxY*2/3, paint);
    Log.v("id1","message1");
    if (x_touch>0 && y_touch > 0)
        canvas.drawText("X",x_touch,y_touch,paint);
}

public void setXandY(float x, float y) {
  x_touch = x;
  y_touch = y;
  this.invalidate();
}