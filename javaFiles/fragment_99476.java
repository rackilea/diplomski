private void setupViewPager(ViewPager viewPager) {
    ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
    adapter.addFrag(QuestionFragment.newInstance(0), "Question1"));
    adapter.addFrag(QuestionFragment.newInstance(1), "Question2"));
    adapter.addFrag(QuestionFragment.newInstance(2), "Question3"));
    viewPager.setOffscreenPageLimit(adapter.getCount());
    viewPager.setAdapter(adapter);
}