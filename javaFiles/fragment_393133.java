Animation shrink, grow;

@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main);

    //I chose onCreate(), but make the animations however suits you.
    //The animations need only be created once.

    //From 100% to 70% about center
    shrink = new ScaleAnimation(1.0f, 0.7f, 1.0f, 0.7f, ScaleAnimation.RELATIVE_TO_SELF, 0.5f, ScaleAnimation.RELATIVE_TO_SELF,0.5f);
    shrink.setDuration(200);
    shrink.setFillAfter(true);

    //From 70% to 100% about center
    grow = new ScaleAnimation(0.7f, 1.0f, 0.7f, 1.0f, ScaleAnimation.RELATIVE_TO_SELF,0.5f,ScaleAnimation.RELATIVE_TO_SELF,0.5f);
    grow.setDuration(200);
    grow.setFillAfter(true);
}

@Override
public void onTouch(View v, MotionEvent event) {
    switch(event.getAction()) {
    case MotionEvent.ACTION_DOWN:
        v.startAnimation(shrink);
        break;
    case MotionEvent.ACTION_UP:
        v.startAnimation(grow);
        break;
    default:
        break;
    }
}