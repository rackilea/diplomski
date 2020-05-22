public class TestActivity extends Activity {

  private static String TAG = "TestActivity";
  private RelativeLayout mRelativeLayout;
  private ImageView mPhoto;
  private ImageView mPhotoTwo;
  private float mStartX;
  private float mStartY;
  private float mDeltaX;
  private float mDeltaY;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_test);
    Log.d(TAG, "onCreate");

    mRelativeLayout = (RelativeLayout)findViewById(R.id.relativelayout);
    mPhoto = (ImageView)findViewById(R.id.photo);
    mPhotoTwo = (ImageView)findViewById(R.id.photo_two);

    ViewTreeObserver observer = mRelativeLayout.getViewTreeObserver();
    observer.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
      @Override
      public void onGlobalLayout() {
        float viewX = mPhoto.getX();
        float viewY = mPhoto.getY();

        mDeltaX = mPhoto.getWidth() - mPhotoTwo.getWidth();
        mDeltaY = mPhoto.getHeight() - mPhotoTwo.getHeight();

        float valueTwoX = viewX + mDeltaX;
        float valueTwoY = viewY + mDeltaY;

        mPhotoTwo.setX(valueTwoX);
        mPhotoTwo.setY(valueTwoY);
      }
    });


    mPhoto.setOnTouchListener(new View.OnTouchListener(){
      @Override
      public boolean onTouch(View view, MotionEvent e) {
        boolean result = false;
        int action = e.getAction();

        if(action == MotionEvent.ACTION_DOWN){

          mStartX = e.getX();
          mStartY = e.getY();
          result = true;

        }else if(action == MotionEvent.ACTION_MOVE){

          float x = e.getX();
          float y = e.getY();
          float deltaX = x - mStartX;
          float deltaY = y - mStartY;

          float viewX = view.getX();
          float viewY = view.getY();
          float valueX = deltaX + viewX;
          float valueY = deltaY + viewY;

          mPhoto.setX(valueX);
          mPhoto.setY(valueY);

          float valueTwoX = valueX + mDeltaX;
          float valueTwoY = valueY + mDeltaY;

          mPhotoTwo.setX(valueTwoX);
          mPhotoTwo.setY(valueTwoY);

          result = true;
        }

        return result;

      }
    });
  }
}