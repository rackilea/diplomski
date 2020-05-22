// filling the sizes used for calculating the pref
Dimension extentSize = null;
Dimension viewSize = null;
Component view = null;

if (viewport != null) {
    extentSize = viewport.getPreferredSize();
    view = viewport.getView();
    if (view != null) {
        viewSize = view.getPreferredSize();
    } else {
        viewSize = new Dimension(0, 0);
    }
}

....

// the part trying to take the scrollbar width into account

if ((vsb != null) && (vsbPolicy != VERTICAL_SCROLLBAR_NEVER)) {
    if (vsbPolicy == VERTICAL_SCROLLBAR_ALWAYS) {
        prefWidth += vsb.getPreferredSize().width;
    }
    else if ((viewSize != null) && (extentSize != null)) {
        boolean canScroll = true;
        if (view instanceof Scrollable) {
            canScroll = !((Scrollable)view).getScrollableTracksViewportHeight();
        }
        if (canScroll && 
            // following condition is the **culprit** 
            (viewSize.height > extentSize.height)) {
            prefWidth += vsb.getPreferredSize().width;
        }
    }
}