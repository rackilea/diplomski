public class MainActivity extends Activity
{
    static int ScreenWidth;
    static int ScreenHeight;
    static int ScreenWidthLandscape;
    static int ScreenHeightLandscape;

    private RelativeLayout layout;
    private RelativeLayout.LayoutParams params;
    private View top;
    private View bottom;

    @SuppressWarnings("deprecation")
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        layout = new RelativeLayout(this);
        top = new View(this);
        bottom = new View(this);
        RelativeLayout.LayoutParams viewParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 1);
        viewParams.addRule(RelativeLayout.ALIGN_PARENT_TOP);
        top.setLayoutParams(viewParams);
        viewParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 1);
        viewParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
        bottom.setLayoutParams(viewParams);
        layout.addView(top);
        layout.addView(bottom);
        setContentView(layout);
        final Intent intent = new Intent(this, myPackage.learnSpanishVerbs.Start.class);

        final View view = getWindow().getDecorView().getRootView();
        ViewTreeObserver vto = view.getViewTreeObserver();
        vto.addOnGlobalLayoutListener(new OnGlobalLayoutListener()
        {
            @Override
            public void onGlobalLayout()
            {
                int topLoc[] = new int[2];
                top.getLocationOnScreen(topLoc);
                int BottomLoc[] = new int[2];
                bottom.getLocationOnScreen(BottomLoc);
                boolean portrait = getResources().getConfiguration().orientation != Configuration.ORIENTATION_LANDSCAPE;
                if (portrait)
                {
                    ScreenWidth = top.getWidth();
                    ScreenHeight = BottomLoc[1] - topLoc[1];
                }
                else
                {
                    ScreenWidthLandscape = top.getWidth();
                    ScreenHeightLandscape = BottomLoc[1] - topLoc[1];
                }

                if (Build.VERSION.SDK_INT < 16)
                    view.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                else
                    view.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                startActivity(intent);
                finish();
            } 
        });
    }
}