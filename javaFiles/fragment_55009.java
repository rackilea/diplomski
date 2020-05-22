public TabAdapter(FragmentManager fm,int numberOfTabs,CharSequence titles[]) {
    super(fm);
    this.numOfTabs = numberOfTabs;
    this.titles = titles;
    stopwatchFragment = new StopwatchFragment();
    countdownFragment = new CountdownFragment();
}