@Override
public boolean dispatchTouchEvent(MotionEvent ev) {
        float currentActivityScaleX = ViewHelper.getScaleX(viewActivity);
        if (currentActivityScaleX == 1.0f) setScaleDirectionByRawX(ev.getRawX());

        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                lastActionDownX = ev.getX();
                lastActionDownY = ev.getY();
                isInIgnoredView = isInIgnoredView(ev) && !isOpened();
                pressedState = PRESSED_DOWN;
                break;

            case MotionEvent.ACTION_MOVE:
                **if (lastActionDownX > getScreenWidth() / 2) {
                    break
                }**
                if (isInIgnoredView || isInDisableDirection(scaleDirection)) break;

                if (pressedState != PRESSED_DOWN && pressedState != PRESSED_MOVE_HORIZONTAL) break;

                int xOffset = (int) (ev.getX() - lastActionDownX);
                int yOffset = (int) (ev.getY() - lastActionDownY);

                if (pressedState == PRESSED_DOWN) {
                    if (yOffset > 25 || yOffset < -25) {
                        pressedState = PRESSED_MOVE_VERTICAL;
                        break;
                    }
                    if (xOffset < -50 || xOffset > 50) {
                        pressedState = PRESSED_MOVE_HORIZONTAL;
                        ev.setAction(MotionEvent.ACTION_CANCEL);
                    }
                } else
                    if (pressedState == PRESSED_MOVE_HORIZONTAL) {
                        if (currentActivityScaleX < 0.95) showScrollViewMenu(scrollViewMenu);

                        float targetScale = getTargetScale(ev.getRawX());
                        if (mUse3D) {
                            int angle = scaleDirection == DIRECTION_LEFT ? -ROTATE_Y_ANGLE :
                                    ROTATE_Y_ANGLE;
                            angle *= (1 - targetScale) * 2;
                            ViewHelper.setRotationY(viewActivity, angle);

                            ViewHelper.setScaleX(imageViewShadow, targetScale - shadowAdjustScaleX);
                            ViewHelper.setScaleY(imageViewShadow, targetScale - shadowAdjustScaleY);
                        } else {
                            ViewHelper.setScaleX(imageViewShadow, targetScale + shadowAdjustScaleX);
                            ViewHelper.setScaleY(imageViewShadow, targetScale + shadowAdjustScaleY);
                        }
                        ViewHelper.setScaleX(viewActivity, targetScale);
                        ViewHelper.setScaleY(viewActivity, targetScale);
                        ViewHelper.setAlpha(scrollViewMenu, (1 - targetScale) * 2.0f);

                        lastRawX = ev.getRawX();
                        return true;
                    }

                break;

            case MotionEvent.ACTION_UP:


              **if (lastActionDownX > getScreenWidth() / 2) {
                    break
                }**
                if (isInIgnoredView) break;
                if (pressedState != PRESSED_MOVE_HORIZONTAL) break;

                pressedState = PRESSED_DONE;
                if (isOpened()) {
                    if (currentActivityScaleX > 0.56f) closeMenu();
                    else openMenu(scaleDirection);
                } else {
                    if (currentActivityScaleX < 0.94f) {
                        openMenu(scaleDirection);
                    } else {
                        closeMenu();
                    }
                }

                break;

        }
        lastRawX = ev.getRawX();
        return super.dispatchTouchEvent(ev);
    }