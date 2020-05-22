public class MainActivity extends Activity {


Button mButton;
CustomView mCustomView;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    setContentView(R.layout.activity_main);
    mButton = (Button)findViewById(R.id.button);
    mCustomView = (CustomView)findViewById(R.id.customv);

    mCustomView.setSwipeListener(new CustomView.swipeInterface() {
        @Override
        public void swipe(CustomView.SwipeEnum swipeEnum) {
            if (swipeEnum == CustomView.SwipeEnum.DOWN){
                mButton.setY(200);
            }
            if (swipeEnum == CustomView.SwipeEnum.TOP){
                mButton.setY(0);
            }
            if (swipeEnum == CustomView.SwipeEnum.RIGHT){
                mButton.setX(200);
            }
            if (swipeEnum == CustomView.SwipeEnum.LEFT){
                mButton.setX(0);
            }
        }
    });
}
}