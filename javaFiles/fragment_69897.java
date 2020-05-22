public class ActivityDragAndDrop extends Activity
{
    private Rect rect;   
    DragShadowBuilder shadowBuilder;
    private CustomScrollView customScrollView;
    private LinearLayout llMain;
    private float defaultPos;
    private float heightRequestItem ;
    private float halfitemHeight;
    private int  lastAddedAt=-1;
    float lastY=-1;
    float prevPos=-1;
    Display display;
    float screenWidth,screenheight;
    Timer t;
    LayoutInflater inflater;

    private int widthRequestItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drag_and_drop);
        initData();
        initUI();
    }

    private void initData() 
    {
        display = getWindowManager().getDefaultDisplay();
        screenWidth = display.getWidth();
        screenheight = display.getHeight();
        heightRequestItem= getResources().getDimensionPixelSize(R.dimen.item_height);   
        halfitemHeight=heightRequestItem/2;
    }

    private void initUI() 
    {
        customScrollView=(CustomScrollView) findViewById(R.id.scrollView);
        llMain=(LinearLayout)findViewById(R.id.llMain);
        inflater=(LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);

        for(int i=0;i<10;i++)
        {
            View vTemp=inflater.inflate(R.layout.single_tv_tag_name, null);
            TextView tvTagName=((TextView)vTemp.findViewById(R.id.tvTagName));
            tvTagName.setText("Tag"+i);
            tvTagName.setTag(""+i);


            vTemp.setOnTouchListener(new ChoiceTouchListener());
            vTemp.setOnDragListener(new ChoiceDragListener());

            llMain.addView(vTemp);
        } 
        View vBlank=inflater.inflate(R.layout.blank_layout, null);
        vBlank.setOnTouchListener(new ChoiceTouchListener());
        vBlank.setOnDragListener(new ChoiceDragListener());
        llMain.addView(vBlank);
        View vBlank1=inflater.inflate(R.layout.blank_layout, null);
        vBlank1.setOnTouchListener(new ChoiceTouchListener());
        vBlank1.setOnDragListener(new ChoiceDragListener());
        llMain.addView(vBlank1);

        t=new Timer();
        t.schedule(new TimerTask() {

            @Override
            public void run() {

                runOnUiThread(new Runnable() {

                    @Override
                    public void run() {
                        findHeight();

                    }
                });
            }
        }, 200);

    }

    private void findHeight() 
    {
        heightRequestItem=llMain.getChildAt(0).getMeasuredHeight();
         widthRequestItem=llMain.getChildAt(0).getMeasuredWidth();
        Toast.makeText(getApplicationContext(), " "+heightRequestItem, Toast.LENGTH_LONG).show();

    }
    private final class ChoiceTouchListener implements OnTouchListener 
    {

        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {

            if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) 
            {
                 rect = new Rect(view.getLeft(), view.getTop(), view.getRight(),view.getBottom());

                prevPos=view.getY();
                ClipData data = ClipData.newPlainText("", "");

                Point offset = new Point((int) motionEvent.getX(), (int) motionEvent.getY());
                  shadowBuilder = new CustomDragShadowBuilder(view, offset);

                view.startDrag(data, shadowBuilder, view, 1);
                return true;
            }
             else if (motionEvent.getAction() == MotionEvent.ACTION_MOVE) 
             {


                 return true;
             } else if (motionEvent.getAction() == MotionEvent.ACTION_UP) {


                 return true;
             }
            return false;

        }

    }
    private class ChoiceDragListener implements OnDragListener 
    {



        private int FLAG;
        private boolean containsDragable;
        private int _yDelta;

        @Override
        public boolean onDrag(View v, DragEvent event) {




                View view = (View) event.getLocalState();

        //view being dragged and dropped
        LinearLayout dropped = (LinearLayout) view;


        //view dragged item is being dropped on
        LinearLayout dropTarget = (LinearLayout) v;





            switch (event.getAction()) {
            case DragEvent.ACTION_DRAG_STARTED:
                //no action necessary

                break;
            case DragEvent.ACTION_DRAG_ENTERED:
                //no action necessary

                break;
            case DragEvent.ACTION_DRAG_EXITED:       
                //no action necessary

                break;
            case DragEvent.ACTION_DROP:




                float lastPos=dropTarget.getY();
                View vBlank=inflater.inflate(R.layout.single_tv_tag_name, null);
                ((TextView)vBlank.findViewById(R.id.tvTagName)).setText(((TextView)dropped.findViewById(R.id.tvTagName)).getText());
                vBlank.setOnTouchListener(new ChoiceTouchListener());
                vBlank.setOnDragListener(new ChoiceDragListener());
                llMain.addView(vBlank, ((int)(lastPos/heightRequestItem)));
                llMain.removeView(dropped);

                break;
            case DragEvent.ACTION_DRAG_ENDED:
                //no action necessary

                break;
            default:
                break;
        }
            return true;
        }


    }


    public class CustomDragShadowBuilder extends View.DragShadowBuilder {

        private Point _offset;


        public CustomDragShadowBuilder(View view, Point offset) {

            // Stores the View parameter passed to myDragShadowBuilder.
            super(view);


            _offset = offset;
        }

        @Override
        public void onProvideShadowMetrics (Point size, Point touch) {


            size.set(getView().getWidth(), getView().getHeight());


            touch.set(_offset.x, _offset.y);
        }

        }


}