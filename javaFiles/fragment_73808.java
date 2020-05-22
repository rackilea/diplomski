import android.os.Handler;

public class ShowActivity extends Activity
{
    Handler handler;
    TextView mSwitcher;

    Animation in;
    Animation out;

    int fadeCount;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);

        fadeCount = 0;

        handler = new Handler();

        mSwitcher = (TextView) findViewById(R.id.textView);
        mSwitcher.setText("old text");

        in = new AlphaAnimation(0.0f, 1.0f);
        in.setDuration(5000);

        out = new AlphaAnimation(1.0f, 0.0f);
        out.setDuration(5000);
        out.setAnimationListener(new Animation.AnimationListener() {

            @Override
            public void onAnimationEnd(Animation animation) {
                fadeCount++;
             if (fadeCount == 3){
                mSwitcher.setText("");
                Intent i = new Intent(getApplication() ,  MainActivity.class);
                startActivity(i);
             }
             else {
                if (fadeCount == 1) {
                    mSwitcher.setText("Text 2.");
                } else {
                    mSwitcher.setText("New Text");
                }

                mSwitcher.startAnimation(in);
                handler.postDelayed(mFadeOut, 5000);
             }    
            }

            @Override
            public void onAnimationRepeat(Animation arg0) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onAnimationStart(Animation arg0) {
                // TODO Auto-generated method stub

            }
        });

        //mSwitcher.startAnimation(out);
        mSwitcher.setText("Text 1.");
        mSwitcher.startAnimation(in);

       /*
        mSwitcher.startAnimation(out);
        mSwitcher.setText("Text 2.");
        mSwitcher.startAnimation(in);
        */

        handler.postDelayed(mFadeOut, 5000);

    }

    private Runnable mFadeOut =new Runnable(){

        @Override
        public void run() {
            //Speed up the last fade-out so that the Activity opens faster
            if (fadeCount == 2){
                out.setDuration(2000);
            }
            mSwitcher.startAnimation(out);
        }
    };
}