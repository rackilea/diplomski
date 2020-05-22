import android.content.Context;
    import android.graphics.Canvas;
    import android.graphics.Color;
    import android.graphics.Paint;
    import android.view.View;

    public class DrawView extends View {
        Paint paint = new Paint();

        public DrawView(Context context) {
            super(context);            
        }

        @Override
        public void onDraw(Canvas canvas) {

    //Code to Measure the Screen width in pixels

    Display display = getWindowManager().getDefaultDisplay();
    Point size = new Point();
    display.getSize(size);
    int width = size.x;

            paint.setColor(Color.RED);
    canvas.drawRect(0, 0, 5, canvas.getHeight(), paint );

    paint.setColor(Color.RED);
    canvas.drawRect(width-canvas.getWidth(), 0, width, canvas.getHeight(), paint );
        }
}