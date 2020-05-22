@Override
public void onDrawerSlide(View view, float slideOffset) {
    // blocks the animation
    super.onDrawerSlide(view, 0);
}

// from the animator function above
mDrawerToggle.onDrawerSlide(drawerLayout, slideOffset);