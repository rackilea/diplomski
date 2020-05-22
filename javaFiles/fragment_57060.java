@Override
public ScreenShotable onSwitch(Resourceble resourceble, ScreenShotable screenShotable, int position) {

    int primaryColorCanvas = R.color.colorPrimary;

    switch (resourceble.getName()) {
        case ContentFragment.CLOSE:
            return screenShotable;

        case ContentFragment.DASHBOARD:
            DashboardFragment fragment = DashboardFragment.newInstance(primaryColorCanvas);
            getSupportFragmentManager().beginTransaction().replace(R.id.content_frame, fragment).commit();
            return replaceFragment(fragment, position);

        case ContentFragment.FRIDGE:
            FridgeFragment fragment2 = FridgeFragment.newInstance(primaryColorCanvas);
            getSupportFragmentManager().beginTransaction().replace(R.id.content_frame, fragment2).commit();
            return replaceFragment(fragment2, position);

        case ContentFragment.COOKBOOK:
            DashboardFragment fragment3 = DashboardFragment.newInstance(primaryColorCanvas);
            getSupportFragmentManager().beginTransaction().replace(R.id.content_frame, fragment3).commit();
            return replaceFragment(fragment3, position);

        case ContentFragment.SHOPPINGLIST:
        case ContentFragment.FEEDBACK:
            ContentFragment fragment4 = ContentFragment.newInstance(primaryColorCanvas);
            getSupportFragmentManager().beginTransaction().replace(R.id.content_frame,fragment4).commit();
            return replaceFragment(fragment4, position);
        default:
            ContentFragment fragment0 = ContentFragment.newInstance(primaryColorCanvas);
            getSupportFragmentManager().beginTransaction().replace(R.id.content_frame,fragment0).commit();
            return replaceFragment(fragment0, position);
    }
}

private ScreenShotable replaceFragment(ScreenShotable screenShotable, int position) {

    int finalRadius = Math.max(contentFrame.getWidth(), contentFrame.getHeight());
    SupportAnimator animator = ViewAnimationUtils.createCircularReveal(contentFrame, 0, position, 0, finalRadius);
    animator.setInterpolator(new AccelerateInterpolator());
    animator.setDuration(ViewAnimator.CIRCULAR_REVEAL_ANIMATION_DURATION);
    findViewById(R.id.content_overlay).setBackground(new BitmapDrawable(getResources(), screenShotable.getBitmap()));
    animator.start();
    return screenShotable;
}

private void initializedMenu() {
    SlideMenuItem menuItem0 = new SlideMenuItem(contentFragment.CLOSE, R.drawable.back_btn);
    list.add(menuItem0);
    SlideMenuItem menuItem = new SlideMenuItem(contentFragment.DASHBOARD, R.drawable.dashboard_icon_a);
    list.add(menuItem);
    SlideMenuItem menuIte2 = new SlideMenuItem(contentFragment.FRIDGE, R.drawable.fridge_icon_a);
    list.add(menuIte2);
    SlideMenuItem menuItem3 = new SlideMenuItem(contentFragment.COOKBOOK, R.drawable.cookbook_icon_a);
    list.add(menuItem3);
    SlideMenuItem menuItem4 = new SlideMenuItem(contentFragment.SHOPPINGLIST, R.drawable.right_icon_a);
    list.add(menuItem4);
    SlideMenuItem menuItem5 = new SlideMenuItem(contentFragment.FEEDBACK, R.drawable.feedback_icon_a);
    list.add(menuItem5);

}