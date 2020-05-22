public class MainActivity extends Activity {

    ViewPager Tab;
    TabPagerAdapter TabAdapter;
    ActionBar actionBar;

    //ARRIVI
    public String[] A_Compagnia = new String[200];
    public String[] A_CodiceVolo = new String[200];
    public String[] A_Citta = new String[200];
    public String[] A_OraPrevista = new String[200];
    public String[] A_OraStimata = new String[200];
    public String[] A_StatoVolo = new String[200];

    // PARTENZE
    public String[] P_Compagnia = new String[200];
    public String[] P_CodiceVolo = new String[200];
    public String[] P_Citta = new String[200];
    public String[] P_OraPrevista = new String[200];
    public String[] P_OraStimata = new String[200];
    public String[] P_StatoVolo = new String[200];

    public String[] A = {"ciao","come"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();

        this.A_Compagnia = intent.getStringArrayExtra("A_Compagnia");
        this.A_CodiceVolo = intent.getStringArrayExtra("A_CodiceVolo");
        this.A_Citta = intent.getStringArrayExtra("A_Citta");
        this.A_OraPrevista = intent.getStringArrayExtra("A_OraPrevista");
        this.A_OraStimata = intent.getStringArrayExtra("A_OraStimata");
        this.A_StatoVolo = intent.getStringArrayExtra("A_StatoVolo");
        this.P_Compagnia = intent.getStringArrayExtra("P_Compagnia");
        this.P_CodiceVolo = intent.getStringArrayExtra("P_CodiceVolo");
        this.P_Citta = intent.getStringArrayExtra("P_Citta");
        this.P_OraPrevista = intent.getStringArrayExtra("P_OraPrevista");
        this.P_OraStimata = intent.getStringArrayExtra("P_OraStimata");
        this.P_StatoVolo = intent.getStringArrayExtra("P_StatoVolo");

        TabAdapter = new TabPagerAdapter(getSupportFragmentManager());
        Tab = (ViewPager)findViewById(R.id.pager);
        Tab.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {

            @Override
            public void onPageSelected(int position) {
                actionBar = getActionBar();
                actionBar.setSelectedNavigationItem(position);
            }
        });
        Tab.setAdapter(TabAdapter);

        actionBar = getActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        ActionBar.TabListener tabListener = new ActionBar.TabListener(){

            @Override
            public void onTabReselected(android.app.ActionBar.Tab arg0,
                                        android.app.FragmentTransaction arg1) {
                // TODO Auto-generated method stub

            }
            @Override
            public void onTabSelected(android.app.ActionBar.Tab arg0,
                                      android.app.FragmentTransaction arg1) {
                // TODO Auto-generated method stub

            }
            @Override
            public void onTabUnselected(android.app.ActionBar.Tab arg0,
                                        android.app.FragmentTransaction arg1) {
                // TODO Auto-generated method stub

            }
        };

        actionBar.addTab(actionBar.newTab().setText("Info").setTabListener(tabListener));
        actionBar.addTab(actionBar.newTab().setText("Arrivi").setTabListener(tabListener));
        actionBar.addTab(actionBar.newTab().setText("Partenze").setTabListener(tabListener));
        //  new FlightTask(this).execute();
        System.out.println(A_Compagnia[1]);
        if (!isOnline()){
            try {
                AlertDialog alertDialog = new AlertDialog.Builder(this).create();

                alertDialog.setTitle("Info");
                alertDialog.setMessage("Connessione Internet non disponibile.");
                alertDialog.setButton("Esci", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }

                });
                alertDialog.show();
            }
            catch(Exception e) { }
        }
    }

    private class TabPagerAdapter extends FragmentStatePagerAdapter {

        public TabPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int i) {
            switch (i) {
                case 0:
                    return new info();
                case 1:
                    return Arrivi.newInstance(A, A_Compagnia, A_CodiceVolo, A_Citta, A_OraPrevista, A_OraStimata, A_StatoVolo);
                case 2:
                    return new partenze();
            }
            return null;
        }

        @Override
        public int getCount() {
            return 3;
        }
    }

    public boolean isOnline() {

        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();

        if (netInfo != null && netInfo.isConnectedOrConnecting()) {
            return true;
        }
        return false;
    }
}