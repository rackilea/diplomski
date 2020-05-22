public class MainActivity extends AppCompatActivity {
    public int posX = 300;
    public int posY = 300;
    public int radius = 50;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        RenderView renderView = new RenderView(this);
        setContentView(renderView);
      /*  while (posX < 2000) {

            renderView.move();
            renderView.invalidate();
        }*/
    }


    class RenderView extends View {
        public RenderView(Context context) {
            super(context);
        }

        public void move() {
            posX++;
            //SystemClock.sleep(2);
        }

        protected void onDraw(Canvas canvas) {
            int width = getWidth();
            int height = getHeight();


            canvas.drawRGB(255, 255, 255);
            Paint ball = new Paint();
            ball.setAntiAlias(true);
            ball.setColor(getResources().getColor(R.color.colorAccent));
            ball.setStyle(Paint.Style.FILL_AND_STROKE);
            canvas.drawCircle(posX, posY, radius, ball);
            if (posX > 350) {
                posX = 300;
                posY+=10;
            }
            posX++;
            invalidate();

        }
    }
}