for (int tabNumber = 1; tabNumber < 8; tabNumber++) {
    ...
    spec = tabHost.newTabSpec(tag).setIndicator(indicator).setContent(intent);
    tabHost.addTab(spec);

    View v = tabWidget.getChildAt(tabNumber - 1);
    registerForContextMenu(v);
    ...
}