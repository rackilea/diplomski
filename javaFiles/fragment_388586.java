private void setupViewPager(ViewPager viewPager) {

    ViewPagerAdapter adapter = new ViewPagerAdapter(getChildFragmentManager());
    adapter.addFragment(new UpcomingShowsActivity(), "Upcoming episodes");
    adapter.addFragment(new UnwatchedEpisodesActivity(), "Unwatched episodes");
    viewPager.setAdapter(adapter);
}