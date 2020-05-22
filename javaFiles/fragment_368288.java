TabHost th = (TabHost) findViewById(R.id.mytabhost);
    th.setup();
    TabSpec ts = th.newTabSpec("whatevver");
    ts.setContent(R.id.tab1);
    ts.setIndicator("TAB1");
    th.addTab(ts);