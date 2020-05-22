package net.njensen.stackoverflow;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Nicklas Jensen on 03/05/15.
 */
public class RevealInPlaceAnimation {

    private final View mContainerView;
    private final View mRevealView;
    private final AnimatorSet mAnimations;

    public RevealInPlaceAnimation(View containerView, View revealView) {
        mContainerView = containerView;
        mRevealView = revealView;

        mAnimations = new AnimatorSet();
        mAnimations.addListener(getAnimationListener());
    }

    public void setDuration(long duration) {
        mAnimations.setDuration(duration);
    }

    public void setInterpolator(TimeInterpolator interpolator) {
        mAnimations.setInterpolator(interpolator);
    }

    public void addListener(Animator.AnimatorListener listener) {
        mAnimations.addListener(listener);
    }

    public void removeListener(Animator.AnimatorListener listener) {
        mAnimations.removeListener(listener);
    }

    public void start() {
        mAnimations.playTogether(getContainerViewAnimation(), getRevealViewAnimation());
        mAnimations.start();
    }

    private float getExpectedRevealViewHeight() {
        return mRevealView.getHeight();
    }

    private float getRevealViewMarginTop() {
        ViewGroup.MarginLayoutParams params = (ViewGroup.MarginLayoutParams) mRevealView.getLayoutParams();
        return params.topMargin;
    }

    private float getRevealViewOffset() {
        return getExpectedRevealViewHeight() + getRevealViewMarginTop();
    }

    private ValueAnimator getContainerViewAnimation() {
        float translationY = -getRevealViewOffset();
        return ObjectAnimator.ofFloat(mContainerView, "translationY", 0.0f, translationY);
    }

    private ValueAnimator getRevealViewAnimation() {
        return ObjectAnimator.ofFloat(mRevealView, "alpha", 0.0f, 1.0f);
    }

    private Animator.AnimatorListener getAnimationListener() {
        return new AnimatorListenerAdapter() {
            @Override
            public void onAnimationStart(Animator animation) {
                super.onAnimationStart(animation);
                mRevealView.setVisibility(View.VISIBLE);
            }
        };
    }

}