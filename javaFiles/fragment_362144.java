@Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tablayout);
                tabHost = getTabHost();  // The activity TabHost
        TabHost.TabSpec spec; 
                spec = tabHost.newTabSpec("TICKETS").setIndicator("").setContent( new Intent().setClass(this, webview.class));

        tabHost.addTab(spec);
}