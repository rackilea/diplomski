/**
 * Check whether entirely new text requires a new view layout
 * or merely a new text layout.
 */
private void checkForRelayout() {
    // If we have a fixed width, we can just swap in a new text layout
    // if the text height stays the same or if the view height is fixed.

    if ((mLayoutParams.width != LayoutParams.WRAP_CONTENT
            || (mMaxWidthMode == mMinWidthMode && mMaxWidth == mMinWidth))
            && (mHint == null || mHintLayout != null)
            && (mRight - mLeft - getCompoundPaddingLeft() - getCompoundPaddingRight() > 0)) {
        // Static width, so try making a new text layout.

        int oldht = mLayout.getHeight();
        int want = mLayout.getWidth();
        int hintWant = mHintLayout == null ? 0 : mHintLayout.getWidth();

        /*
         * No need to bring the text into view, since the size is not
         * changing (unless we do the requestLayout(), in which case it
         * will happen at measure).
         */
        makeNewLayout(want, hintWant, UNKNOWN_BORING, UNKNOWN_BORING,
                      mRight - mLeft - getCompoundPaddingLeft() - getCompoundPaddingRight(),
                      false);

        if (mEllipsize != TextUtils.TruncateAt.MARQUEE) {
            // In a fixed-height view, so use our new text layout.
            if (mLayoutParams.height != LayoutParams.WRAP_CONTENT
                    && mLayoutParams.height != LayoutParams.MATCH_PARENT) {
                autoSizeText();
                invalidate();
                return; // return with out relayout
            }

            // Dynamic height, but height has stayed the same,
            // so use our new text layout.
            if (mLayout.getHeight() == oldht
                    && (mHintLayout == null || mHintLayout.getHeight() == oldht)) {
                autoSizeText();
                invalidate();
                return; // return with out relayout
            }
        }

        // We lose: the height has changed and we have a dynamic height.
        // Request a new view layout using our new text layout.
        requestLayout();
        invalidate();
    } else {
        // Dynamic width, so we have no choice but to request a new
        // view layout with a new text layout.
        nullLayouts();
        requestLayout();
        invalidate();
    }
}