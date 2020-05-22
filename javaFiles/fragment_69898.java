public class CustomScrollView extends ScrollView{

    private OnScrollChanged onScrollChanged;
    private boolean hasScrollListener;




    private int mMaxYOverscrollDistance;    

    public CustomScrollView(Context context, AttributeSet attrs, int defStyle) 
    {
        super(context, attrs, defStyle);
        initBounceScrollView();
    }

    public CustomScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initBounceScrollView();

    }

    public CustomScrollView(Context context) {
        super(context);
        initBounceScrollView();
    }


    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) 
    {
        //if(AppConstants.DEBUG)Log.v(AppConstants.DEBUG_TAG,"onScrollChanged: "+l+":"+t+":"+oldl+":"+oldt);

        if(hasScrollListener)
        {
            onScrollChanged.onScrollChanged(this,l, t, oldl, oldt);

        }

        super.onScrollChanged(l, t, oldl, oldt);
    }

    @Override
    protected void onOverScrolled(int scrollX, int scrollY, boolean clampedX,
            boolean clampedY) {

        super.onOverScrolled(scrollX, scrollY, clampedX, clampedY);
    }

    public OnScrollChanged getOnScrollChanged() {
        return onScrollChanged;
    }

    public void setOnScrollChanged(OnScrollChanged onScrollChanged) {

        this.onScrollChanged = onScrollChanged;
        hasScrollListener = true;
    }

     private void initBounceScrollView()
    {
        //get the density of the screen and do some maths with it on the max overscroll distance
        //variable so that you get similar behaviors no matter what the screen size


        mMaxYOverscrollDistance = getResources().getDimensionPixelSize(R.dimen.height_pullrefresh);//(int) (density * MAX_Y_OVERSCROLL_DISTANCE);
    }

    @Override
    protected boolean overScrollBy(int deltaX, int deltaY, int scrollX, int scrollY, int scrollRangeX, int scrollRangeY, int maxOverScrollX, int maxOverScrollY, boolean isTouchEvent) 
    { 

        //if(AppConstants.DEBUG) Log.v(AppConstants.DEBUG_TAG, "deltaX  "+deltaX+"  "+ deltaY+" "+ scrollX+" "+ scrollY+" "+ scrollRangeX+" "+ scrollRangeY+" "+ maxOverScrollX+" "+ maxOverScrollY+" "+ isTouchEvent);         
        if(scrollY==(-mMaxYOverscrollDistance) && isTouchEvent)
        {
            if(onScrollChanged!=null)   onScrollChanged.onOverScrolledAtMax();
        }
        //This is where the magic happens, we have replaced the incoming maxOverScrollY with our own custom variable mMaxYOverscrollDistance; 
        return super.overScrollBy(deltaX, deltaY, scrollX, scrollY, scrollRangeX, scrollRangeY, maxOverScrollX, mMaxYOverscrollDistance, isTouchEvent);  
    }

}