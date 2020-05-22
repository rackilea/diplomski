public class BannerLayout extends View {

    private final Context mContext;

    private final ViewGroup mPopupLayout;

    private final ViewGroup mParentView;

    public BannerLayout(Activity activity, final Context context) {
        super(context);

        mContext = context;

        final WindowManager.LayoutParams params = new WindowManager.LayoutParams(
                WindowManager.LayoutParams.TYPE_SYSTEM_OVERLAY,
                WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN |
                        WindowManager.LayoutParams.FLAG_WATCH_OUTSIDE_TOUCH,
                PixelFormat.TRANSLUCENT);

        final WindowManager mWinManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mPopupLayout = (RelativeLayout) inflater.inflate(R.layout.popup_activity, null);
        mPopupLayout.setVisibility(GONE);

        params.width = ActionBar.LayoutParams.WRAP_CONTENT;
        params.height = ActionBar.LayoutParams.WRAP_CONTENT;

        // Default variant
        // params.windowAnimations = android.R.style.Animation_Translucent;

        mParentView = new FrameLayout(mContext);

        mWinManager.addView(mParentView, params);

        mParentView.addView(mPopupLayout);
        mPopupLayout.setVisibility(GONE);
    }

    /**
     * Shows view
     */
    public void show(){
        final Animation in = AnimationUtils.loadAnimation(this.mContext, android.R.anim.fade_in);

        in.setDuration(2000);

        mPopupLayout.setVisibility(VISIBLE);
        mPopupLayout.startAnimation(in);
    }

    /**
     * Hides view
     */
    public void hide() {
        mPopupLayout.setVisibility(GONE);
    }
}