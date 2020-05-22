public MyActivity extends Activity 
{ 
    private Handler mHandler = new Handler(); 

private Runnable mUpdateTask = new Runnable() 
{ 
    public void run() 
    { 
        Log.i("repeatBtn", "repeat click"); 
        mHandler.postAtTime(this, SystemClock.uptimeMillis() + 100); 
    } 
}; 

public void onCreate(Bundle savedInstanceState) 
{ 
    super.onCreate(savedInstanceState); 
    setContentView(R.layout.main); 

    Button repeatButton = (Button) findViewById(R.id.repeatButton); 
    repeatButton.setOnTouchListener(new OnTouchListener() 
    { 
        public boolean onTouch(View view, MotionEvent motionevent) 
        { 
            int action = motionevent.getAction(); 
            if (action == MotionEvent.ACTION_DOWN) 
            { 
                Log.i("repeatBtn", "MotionEvent.ACTION_DOWN"); 
                mHandler.removeCallbacks(mUpdateTask); 
                mHandler.postAtTime(mUpdateTask, SystemClock.uptimeMillis() + 100); 
            } 
            else if (action == MotionEvent.ACTION_UP) 
            { 
                Log.i("repeatBtn", "MotionEvent.ACTION_UP"); 
                mHandler.removeCallbacks(mUpdateTask); 
            }
            return false;
        }
    });
}
}