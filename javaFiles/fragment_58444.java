public void scrollCenterBarItem(DrinkCategoryView toBarItem) {
    int endPos    = (int) toBarItem.getView().getX();
    int halfWidth = (int) toBarItem.getView().getWidth() / 2;

    barsScroller.smoothScrollTo(endPos + halfWidth - barScroller.getWidth() / 2, 0);
}