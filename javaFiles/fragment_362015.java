package com.seifi.dragtestapplication;

import android.graphics.Point;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;

class ViewOnTouchListener implements View.OnTouchListener {
    Point pushPoint, closePoint;
    int lastImgLeft;
    int lastImgTop;
    FrameLayout.LayoutParams viewLP;
    FrameLayout.LayoutParams pushBtnLP;
    FrameLayout.LayoutParams closeBtnLP;
    int lastPushBtnLeft, lastCloseBtnLeft;
    int lastPushBtnTop, lastCloseBtnTop;
    private View mPushView, mCloseView, mShadowView;

    ViewOnTouchListener(View mPushView, View mCloseView, View mShadowView) {
        this.mPushView = mPushView;
        this.mCloseView = mCloseView;
        this.mShadowView = mShadowView;
    }

    @Override
    public boolean onTouch(View view, MotionEvent event) {
        switch (event.getAction() & MotionEvent.ACTION_MASK) {
            case MotionEvent.ACTION_DOWN:
                if (null == viewLP) {
                    viewLP = (FrameLayout.LayoutParams) view.getLayoutParams();
                }
                if (null == pushBtnLP) {
                    pushBtnLP = (FrameLayout.LayoutParams) mPushView.getLayoutParams();
                }

                if (null == closeBtnLP) {
                    closeBtnLP = (FrameLayout.LayoutParams) mCloseView.getLayoutParams();
                }
                closePoint = getRawPoint(event);
                pushPoint = getRawPoint(event);
                lastImgLeft = viewLP.leftMargin;
                lastImgTop = viewLP.topMargin;
                lastPushBtnLeft = pushBtnLP.leftMargin;
                lastPushBtnTop = pushBtnLP.topMargin;

                lastCloseBtnLeft = closeBtnLP.leftMargin;
                lastCloseBtnTop = closeBtnLP.topMargin;
                (mShadowView).setBackgroundResource(R.drawable.my_shadow_pressed);

                mShadowView.setVisibility(View.VISIBLE);
                mCloseView.setVisibility(View.VISIBLE);
                mPushView.setVisibility(View.VISIBLE);
                break;
            case MotionEvent.ACTION_MOVE:
                Point newPoint = getRawPoint(event);
                float moveX = newPoint.x - pushPoint.x;
                float moveY = newPoint.y - pushPoint.y;

                viewLP.leftMargin = (int) (lastImgLeft + moveX);
                viewLP.topMargin = (int) (lastImgTop + moveY);
                view.setLayoutParams(viewLP);

                pushBtnLP.leftMargin = (int) (lastPushBtnLeft + moveX);
                pushBtnLP.topMargin = (int) (lastPushBtnTop + moveY);
                mPushView.setLayoutParams(pushBtnLP);

                closeBtnLP.leftMargin = (int) (lastCloseBtnLeft + moveX);
                closeBtnLP.topMargin = (int) (lastCloseBtnTop + moveY);
                mCloseView.setLayoutParams(closeBtnLP);

                break;
            case MotionEvent.ACTION_UP: {
                (mShadowView).setBackgroundResource(R.drawable.my_shadow);
                break;
            }
        }
        return false;
    }

    private Point getRawPoint(MotionEvent event) {
        return new Point((int) event.getRawX(), (int) event.getRawY());
    }
}