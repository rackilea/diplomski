private void addTab(TabHost tabHost,
                    TabHost.TabSpec tabSpec, TabInfo tabInfo) {
    // Attach a Tab view factory to the spec
    tabSpec.setContent(new TabFactory(getActivity()));
    String tag = tabSpec.getTag();
    tabSpec.setIndicator(tag); // you may want a different label
    ...
}