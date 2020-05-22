public class CustomRectangle extends View {

private Bitmap bitTopLeft;
private Bitmap bitTopRight;
private Bitmap bitBottomLeft;
private Bitmap bitBottomRight;
private Paint rectAnglePaint;
private Context context;
private Paint bitmapPaint;
private Rect rect;
private int maxX;
private int maxY;
private int centerX;
private int centerY;
private Paint canvasPaint;
private String direction;

public CustomRectangle(Context context) {
    super(context);
    this.context = context;
    Init();
}

private void Init() {
    bitTopLeft = BitmapFactory.decodeResource(context.getResources(),
            R.drawable.squarsmall);
    bitTopRight = BitmapFactory.decodeResource(context.getResources(),
            R.drawable.squarsmall);
    bitBottomLeft = BitmapFactory.decodeResource(context.getResources(),
            R.drawable.squarsmall);
    bitBottomRight = BitmapFactory.decodeResource(context.getResources(),
            R.drawable.squarsmall);

    rectAnglePaint = new Paint();
    rectAnglePaint.setColor(Color.GREEN);

    rectAnglePaint.setStrokeWidth(5);
    rectAnglePaint.setStyle(Paint.Style.STROKE);

    rectAnglePaint = new Paint();
    rectAnglePaint.setColor(Color.GREEN);

    rectAnglePaint.setStrokeWidth(5);
    rectAnglePaint.setStyle(Paint.Style.STROKE);

    bitmapPaint = new Paint();
    bitmapPaint.setColor(Color.BLACK);
    rect = new Rect();

    Display display = ((Activity) context).getWindowManager()
            .getDefaultDisplay();
    Point size = new Point();
    display.getSize(size);
    maxX = size.x;
    maxY = size.y;

    centerX = maxX / 2;
    centerY = maxY / 2;

    rect.left = centerX / 2 + bitBottomRight.getWidth() / 2;
    rect.top = centerY / 2 + bitBottomRight.getWidth() / 2;
    rect.right = centerX + centerX / 2 + bitBottomRight.getWidth() / 2;
    rect.bottom = centerY + centerY / 2 + bitBottomRight.getWidth() / 2;

    canvasPaint = new Paint();
    canvasPaint.setColor(Color.TRANSPARENT);
}

@Override
protected void onDraw(Canvas canvas) {
    canvas.drawPaint(canvasPaint);
    // Path p = new Path();
    canvas.drawBitmap(bitTopLeft,
            rect.left - bitBottomRight.getWidth() / 2, rect.top
                    - bitBottomRight.getWidth() / 2, bitmapPaint);
    canvas.drawBitmap(bitTopRight, rect.right - bitBottomRight.getWidth()
            / 2, rect.top - bitBottomRight.getWidth() / 2, bitmapPaint);
    canvas.drawBitmap(bitBottomLeft, rect.left - bitBottomRight.getWidth()
            / 2, rect.bottom - bitBottomRight.getWidth() / 2, bitmapPaint);
    canvas.drawBitmap(bitBottomRight,
            rect.right - bitBottomRight.getWidth() / 2, rect.bottom
                    - bitBottomRight.getWidth() / 2, bitmapPaint);

    canvas.drawRect(rect, rectAnglePaint);
}
float x1, x2, y1, y2, dx, dy;

@Override
public boolean onTouchEvent(MotionEvent event) {
    switch (event.getAction()) {
    case MotionEvent.ACTION_DOWN:
        x1 = event.getRawX();
        y1 = event.getRawY();
        invalidate();
        break;
    case MotionEvent.ACTION_MOVE:
        x2 = event.getRawX();
        y2 = event.getRawY();
        int currentx = (int) event.getX();
        int currenty = (int) event.getY();
        Calculatingpoint(currentx, currenty);

        break;

    case MotionEvent.ACTION_UP:

        break;
    default:
        break;
    }
    return true;
}

private void Calculatingpoint(int x, int y) {
    if (x2 < maxX && y2 < maxY) {
        int dx = 0;
        int dy = 0;

        // dx = rect.right - (int)x2 ;
        // dy = (int)y2 - rect.top ;
        //
        // Log.e("dx", ""+dx);
        // Log.e("dy", ""+dy);

        boolean isLeft = false;
        boolean isTop = false;

        if (x2 > maxX / 2) {
            direction = "right";
            isLeft = false;
        } else {
            direction = "left";
            isLeft = true;
        }

        if (y2 > maxY / 2) {
            direction = "bottom";
            isTop = false;
        } else {
            direction = "top";
            isTop = true;
        }

        if (!isLeft && !isTop) {
            dx = rect.right - (int) x2;

            dy = rect.bottom - (int) y2;
        }

        if (isLeft && !isTop) {
            dx = (int) x2 - rect.left;
            dy = rect.bottom - (int) y2;
        }

        if (isLeft && isTop) {
            dx = (int) x2 - rect.left;
            dy = (int) y2 - rect.top;
        }

        if (!isLeft && isTop) {
            dx = rect.right - (int) x2;
            dy = (int) y2 - rect.top;
        }
// this will perfect 
        rect.inset(dx, dy);
        invalidate();

    }
}
}