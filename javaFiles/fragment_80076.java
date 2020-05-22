View parent_view = null;

    if (position == 0) {
        parent_view = getViewForPageOne();

    } else if (position == 1) {
        parent_view = getViewForPageTwo();

    .........

    ((ViewPager) collection).addView(parent_view, 0);
    return parent_view;

}