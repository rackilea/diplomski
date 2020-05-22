public void removeAllViewsInLayout() {
    final int count = mChildrenCount;
    if (count <= 0) {
        return;
    }

    final View[] children = mChildren;
    mChildrenCount = 0;

    final View focused = mFocused;
    final boolean detach = mAttachInfo != null;
    View clearChildFocus = null;

    needGlobalAttributesUpdate(false);

    for (int i = count - 1; i >= 0; i--) {
        final View view = children[i];

        if (mTransition != null) {
            mTransition.removeChild(this, view);
        }

        if (view == focused) {
            view.clearFocusForRemoval();
            clearChildFocus = view;
        }

        if (view.getAnimation() != null ||
                (mTransitioningViews != null && mTransitioningViews.contains(view))) {
            addDisappearingView(view);
        } else if (detach) {
           view.dispatchDetachedFromWindow();
        }

        onViewRemoved(view);

        view.mParent = null;
        children[i] = null;
    }

    if (clearChildFocus != null) {
        clearChildFocus(clearChildFocus);
    }
}