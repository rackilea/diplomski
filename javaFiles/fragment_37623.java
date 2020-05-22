View myView;
   public boolean tmpflag = true;


   @Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    myView= findViewById(R.id.Rec);
}
@Override
  public boolean dispatchTouchEvent(MotionEvent ev) {
    int action = ev.getAction();

    if (action == MotionEvent.ACTION_DOWN) {

        if (tmpflag) {

           myView.setBackgroundColor(Color.RED);
            tmpflag = false;
        } else {

            myView.setBackgroundColor(Color.BLUE);
            tmpflag = true;
        }
        return true;
    }

    return super.dispatchTouchEvent(ev);
  }

  public boolean dispatchKeyEvent(KeyEvent event) {

    int action = event.getAction();
    int keycode= event.getKeyCode();


    if (action == KeyEvent.ACTION_DOWN) {
        if (keycode ==KeyEvent.KEYCODE_ENTER){


        if (tmpflag) {

            myView.setBackgroundColor(Color.RED);
            tmpflag = false;
        } else {

            myView.setBackgroundColor(Color.BLUE);
            tmpflag = true;
        } }
        return true;
    }

    return super.dispatchKeyEvent(event);
 }