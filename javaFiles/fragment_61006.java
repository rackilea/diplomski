public class CanvasWithButtonsActivity extends Activity {
    boolean showCircle = true;
    private CanvasView mCanvasView;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout());

        findViewById(R.id.buttonHide).setOnClickListener(
                new OnClickListener() {      
                public void onClick(View v) {
                    //HIDE
                    showCircle = false;
                    //How do i invalidate my canvas from here?
                    if (mCanvasView != null) {
                        mCanvasView.invalidate();
                    }
                }  
        });

        findViewById(R.id.buttonShow).setOnClickListener(
                new OnClickListener() {      
                public void onClick(View v) {
                    //SHOW
                    showCircle = true;
                    //How do i invalidate my canvas from here?
                    if (mCanvasView != null) {
                        mCanvasView.invalidate();
                    }
                }  
        });
    }

    public RelativeLayout layout(){
        RelativeLayout mainLayout = new RelativeLayout(this);
        mainLayout.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.FILL_PARENT,
                LinearLayout.LayoutParams.FILL_PARENT, 1));
        mainLayout.setBackgroundColor(Color.WHITE);

        View buttonLayout = LayoutInflater.from(getBaseContext()).inflate(R.layout.main, null);
        buttonLayout.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.FILL_PARENT,
                LinearLayout.LayoutParams.FILL_PARENT, 1));
        mCanvasView = new CanvasView(getApplicationContext());
        mainLayout.addView(mCanvasView);
        mainLayout.addView(buttonLayout);

        return mainLayout;
    }

    private class CanvasView extends View{

        public CanvasView(Context context) {
            super(context);
            // TODO Auto-generated constructor stub
        }

        protected void onDraw(Canvas myCanvas){
            Paint myPaint = new Paint();
            myPaint.setColor(Color.BLUE);
            if(showCircle == true)
                myCanvas.drawCircle(myCanvas.getWidth()/2, 100, 20, myPaint);
        }
    }
}