public class MyCustomView extends RelativeLayout {
    private LinearLayout mContentView;

    public MyCustomView(Context context) {
        this(context, null);
    }

    public MyCustomView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MyCustomView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        //Inflate and attach your child XML
        LayoutInflater.from(context).inflate(R.layout.custom_layout, this);
        //Get a reference to the layout where you want children to be placed
        mContentView = (LinearLayout) findViewById(R.id.content);

        //Do any more custom init you would like to access children and do setup
    }

    @Override
    public void addView(View child, int index, ViewGroup.LayoutParams params) {
        if(mContentView == null){
            super.addView(child, index, params);
        } else {
            //Forward these calls to the content view
            mContentView.addView(child, index, params);
        }
    }
}