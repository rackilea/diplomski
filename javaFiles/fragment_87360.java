public class AnimationControl {
    private AnimatorSet mAnimSet;
    private Object target;
    private float start;
    private float end = 1.0f;
    private float progressWidth;
    private long time;
    private boolean started;
    private long mStartDelay;
    private long mDuration;
    private long mTotalDuration;

    public AnimationControl(AnimatorSet mAnimSet, float start, float end) {
    this(null, mAnimSet, start, end);
    }

    public AnimationControl(Object target, AnimatorSet mAnimSet, float start, float end) {
    for (Animator animator : mAnimSet.getChildAnimations()) {
        if (!(animator instanceof ValueAnimator)) {
        throw new UnsupportedOperationException("Only ValueAnimator and its subclasses are supported");
        }
    }
    this.target = target;
    this.mAnimSet = mAnimSet;
    mStartDelay = mAnimSet.getStartDelay();
    mDuration = mAnimSet.getDuration();
    if (mAnimSet.getDuration() >= 0) {
        long duration = mAnimSet.getDuration();
        for (Animator animator : mAnimSet.getChildAnimations()) {
        animator.setDuration(duration);
        }
    } else {
        for (Animator animator : mAnimSet.getChildAnimations()) {
        long endTime = animator.getStartDelay() + animator.getDuration();
        if (mDuration < endTime) {
            mDuration = endTime;
        }
        }
    }
    mTotalDuration = mStartDelay + mDuration;
    this.start = start;
    this.end = end;
    progressWidth = Math.abs(end - start);
    }

    public void start() {
    if (target != null) {
        for (Animator animator : mAnimSet.getChildAnimations()) {
        animator.setTarget(target);
        }
    }
    }

    public void updateProgress(float progress) {
    if (start < end && progress >= start && progress <= end || start > end && progress >= end && progress <= start) {
        if (start < end) {
        time = (long) (mTotalDuration * (progress - start) / progressWidth);
        } else {
        time = (long) (mTotalDuration - mTotalDuration * (progress - end) / progressWidth);
        }
        time -= mStartDelay;
        if (time > 0) {
        started = true;
        }
        Log.e(getClass().getSimpleName(), "updateState: " + mTotalDuration + ";" + time+"/"+start+"/"+end);
    } else {
        //forward
        if (start < end) {
        if (progress < start) {
            time = 0;
        } else if (progress > end) {
            time = mTotalDuration;
        }
        //backward
        } else if (start > end) {
        if (progress > start) {
            time = 0;
        } else if (progress > end) {
            time = mTotalDuration;
        }
        }
        started = false;
    }
    }

    public void updateState() {
    if (started) {
        for (Animator animator : mAnimSet.getChildAnimations()) {
        ValueAnimator va = (ValueAnimator) animator;
        long absTime = time - va.getStartDelay();
        if (absTime > 0) {
            va.setCurrentPlayTime(absTime);
        }
        }
    }
    }
}