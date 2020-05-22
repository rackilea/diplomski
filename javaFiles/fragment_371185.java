public class MainActivity extends Activity {

DrawLine drawLine;

@Override
public void onCreate(Bundle savedInstanceState) {

    super.onCreate(savedInstanceState);

    drawLine = new DrawLine(this);

    drawLine.setBackgroundColor(Color.CYAN);

    setContentView(drawLine);
  }

    class DrawLine extends View {
        Paint paint = new Paint();
        public DrawLine(Context context) {
            super(context);
            paint.setColor(Color.BLACK);
        }

        @Override
        public void onDraw(Canvas canvas) {
            canvas.drawLine(50, 100, 600, 600, paint);
            canvas.drawLine(50, 550, 770, 0, paint);
        }

    }
}