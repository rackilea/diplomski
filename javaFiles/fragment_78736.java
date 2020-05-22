public class MainActivity extends ActionBarActivity {
float x, y;
RelativeLayout rl;

@Override
protected void onCreate(Bundle savedInstanceState) {


    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    getActionBar().hide();
    rl = (RelativeLayout) findViewById(R.id.root_view);
    rl.setOnTouchListener(new View.OnTouchListener() {
        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                // rl.removeView(iv);
                x = motionEvent.getX();
                y = motionEvent.getY();
                setImageLocation(x, y);
                //rl.addView(iv);
            }
            return false;
        }
    });


}

public void setImageLocation(float x, float y) {
    ImageView newImage;
    RelativeLayout.LayoutParams newparams;
    newparams = new RelativeLayout.LayoutParams(20, 20);
    newparams.setMargins((int) (x-rl.getPaddingLeft()), (int) (y-rl.getPaddingTop()), 0, 0);
    newImage = new ImageView(this);
    newImage.setLayoutParams(newparams);
    newImage.setImageResource(R.drawable.clock);
    rl.addView(newImage);


}