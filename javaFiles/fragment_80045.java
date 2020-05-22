public void selectIndex(int newIndex) {
  mViewPager.setCurrentItem(newIndex);
}

@Override
public void onBackPressed() {
  int currentPosition = mViewPager.getCurrentItem();
  if (currentPosition != 0) {
        mViewPager.setCurrentItem(0);
  } else {
    super.onBackPressed();
  }
}