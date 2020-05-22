public class ProgressAnimator implements TimeAnimator.TimeListener {
    private final List<AnimationControl> animationControls = new ArrayList<>();
    private final MenuItem mMenuItem; //TODO shouldn't be here, add animation end listener
    private final ImageView mImageView;
    private final TimeAnimator mTimeAnim;
    private final AnimatorSet mInternalAnimSet;

    public ProgressAnimator(Context context, MenuItem mMenuItem) {
    if (mMenuItem == null) {
        mImageView = null;
    } else {
        mImageView = (ImageView) LayoutInflater.from(context).inflate(R.layout.menu_animation, null).findViewById(R.id.menu_animation);
        mImageView.setImageDrawable(mMenuItem.getIcon());
    }
    this.mMenuItem = mMenuItem;
    this.mInternalAnimSet = new AnimatorSet();

    mTimeAnim = new TimeAnimator();
    mTimeAnim.setTimeListener(this);
    }

    public void addAnimatorSet(AnimatorSet mAnimSet, float start, float end) {
    animationControls.add(new AnimationControl(mImageView, mAnimSet, start, end));
    }

    public void addAnimatorSet(Object target, AnimatorSet mAnimSet, float start, float end) {
    animationControls.add(new AnimationControl(target, mAnimSet, start, end));
    }

    public void start() {
    ValueAnimator colorAnim = ObjectAnimator.ofInt(new Object() {
        private int dummy;

        public int getDummy() {
        return dummy;
        }

        public void setDummy(int dummy) {
        this.dummy = dummy;
        }
    }, "dummy", 0, 1);
    colorAnim.setDuration(Integer.MAX_VALUE);
    mInternalAnimSet.play(colorAnim).with(mTimeAnim);
    mInternalAnimSet.start();
    if (mMenuItem != null) {
        mMenuItem.setActionView(mImageView);
    }
    for (AnimationControl ctrl : animationControls) {
        ctrl.start();
    }
    }

    public void end() {
    mTimeAnim.end();
    if (mMenuItem != null) {
        mMenuItem.setActionView(null);
    }
    }

    public void updateProgress(float progress) {
    for (AnimationControl ctrl : animationControls) {
        ctrl.updateProgress(progress);
    }
    }

    @Override
    public void onTimeUpdate(TimeAnimator animation, long totalTime, long deltaTime) {
    for (AnimationControl ctrl : animationControls) {
        ctrl.updateState();
    }
    }
}