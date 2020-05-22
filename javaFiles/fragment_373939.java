public class MainActivity extends Activity
{
     FirstView dv;
     @Override
     protected void onCreate(Bundle savedInstanceState) {

    super.onCreate(savedInstanceState);
    dv = new FirstView(this);
    setContentView(R.layout.activity_main);
    final Button b= (Button) findViewById(R.id.button1);
    b.setOnClickListener(new OnClickListener()
    {
        public void onClick(View v) {
            // TODO Auto-generated method stub
            LinearLayout rl= (LinearLayout ) findViewById(R.id.textView1);
            rl.addView(dv);
            b.setVisibility(View.INVISIBLE);

        }
    });         
}
public class FirstView extends View {

private int screenW;
private int screenH;

private float drawScaleW;
private float drawScaleH;

int moveRate = 10, dot1y, dot1x;

private Context myContext;

private Bitmap dot;
private boolean dotSinking = true, gameOver = false;


public FirstView(Context context) {
super(context);
myContext = context;
}

@Override
protected void onSizeChanged(int w, int h, int oldw, int oldh) {
super.onSizeChanged(w, h, oldw, oldh);
dot = BitmapFactory.decodeResource(myContext.getResources(), R.drawable.ic_launcher);
screenW = w;
screenH = h;
drawScaleW = (float) screenW / 800;
drawScaleH = (float) screenH / 600;
dot1y = 0+dot.getHeight();
dot1x = w/2-(dot.getWidth()/2);
}

public void run() {
if (!gameOver) {
    animateDot();  
    invalidate();
}
}
@Override
protected void onDraw(Canvas canvas) {
Paint redPaint = new Paint();
redPaint.setColor(Color.RED);
canvas.drawBitmap(dot, dot1x, dot1y, null);
run();
}
private void animateDot(){
if (dotSinking) {
    if(dot1y<screenH-dot.getHeight())
    dot1y += moveRate;
} 
}
}