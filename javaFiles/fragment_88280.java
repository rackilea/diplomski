public class MainActivity extends AppCompatActivity implement OnTouchListener {

   TouchView touchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        LinearLayout ll = new LinearLayout(this);
        ll.setOrientation(LinearLayout.VERTICAL);
        this.setContentView(ll);

        float x = 500;
        float y = 500;
        float size = 1000;

        touchView = new TouchView(x,y,size,this);
        touchView.setOnTouchListener(this);
        ll.addView(touchView);
    }

    public boolean onTouch(View view, MotionEvent motionEvent){
        float x = motionEvent.getX();
        float y = motionEvent.getY();

        return  true;
    }

}