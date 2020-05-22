public class PixelParticle extends View {

private float locationX;
private float locationY;
private int sizeX;
private int sizeY;
private Paint color;
private Rect rect;
private int paintcolor;
private float myLocX;
private float myLocY;

public PixelParticle(Context context, float locationX, float locationY,
        int sizeX, int sizeY, int paintcolor) {
    super(context);

    this.locationX = locationX;
    this.locationY = locationY;
    this.sizeX = sizeX;
    this.sizeY = sizeY;
    this.paintcolor = paintcolor;

    rect = new Rect();
    color = new Paint();
}

@Override
protected void onDraw(Canvas canvas) {
    super.onDraw(canvas);

    Bitmap myBitmap = BitmapFactory.decodeResource(getResources(),
            R.drawable.ic_launcher);
    Bitmap resizedBitmap = Bitmap.createScaledBitmap(myBitmap, 250, 250,
            true);
    canvas.drawBitmap(resizedBitmap, locationX
            - (resizedBitmap.getWidth() / 2),
            locationY - (resizedBitmap.getHeight() / 2), null);

}}