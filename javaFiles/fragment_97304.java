@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.rl);
    MyView mv = new MyView(this);
    relativeLayout.addView(mv);
}

class MyView extends View
{

    public MyView(Context context) {
        super(context);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        // TODO Auto-generated method stub
        super.onDraw(canvas);
        canvas.drawBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.afor), 100 ,100, null);
    }

}