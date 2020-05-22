public class TestActivity extends Activity {

  private static String TAG = "TestActivity";
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

    mPhoto = (ImageView)findViewById(R.id.photo);
    mPhotoTwo = (ImageView)findViewById(R.id.photo_two);

    mPhoto.setOnTouchListener(new View.OnTouchListener(){
      @Override
      public boolean onTouch(View view, MotionEvent e) {
        boolean result = false;
        int action = e.getAction();

        if(action == MotionEvent.ACTION_DOWN){

          mStartX = e.getX();
          mStartY = e.getY();
          mDeltaX = mPhoto.getWidth() - mPhotoTwo.getWidth();
          mDeltaY = mPhoto.getHeight() - mPhotoTwo.getHeight();
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