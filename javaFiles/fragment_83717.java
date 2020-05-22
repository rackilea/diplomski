public class HelloTabWidget extends TabActivity implements OnTabChangeListener{`

    private TabHost mTabHost;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        Resources res = getResources(); 
        TabHost tabHost = getTabHost();  
        TabHost.TabSpec spec;  
        Intent intent; 
        mTabHost = getTabHost();


        intent = new Intent().setClass(this, BarActivity.class);
        spec = tabHost.newTabSpec("Name").setIndicator("Name",res.getDrawable(R.drawable.ic_tab_name)).setContent(intent);
        tabHost.addTab(spec);

        intent = new Intent().setClass(this, CityActivity.class);
        spec = tabHost.newTabSpec("city").setIndicator("City",res.getDrawable(R.drawable.ic_tab_city)).setContent(intent); 
        tabHost.addTab(spec);

        intent = new Intent().setClass(this, MapsActivity.class);
        spec = tabHost.newTabSpec("Map").setIndicator("Map",res.getDrawable(R.drawable.ic_tab_map)).setContent(intent);
        tabHost.addTab(spec);        

        tabHost.setCurrentTab(2);
        mTabHost.setOnTabChangedListener(this);
    }

    public void onTabChanged(String tabId) {
        Toast.makeText(getApplicationContext(), "Selected Tab "+tabId, Toast.LENGTH_LONG).show();
        Log.i("selected tab index", "Current index - "+ mTabHost.getCurrentTab());      
    }}