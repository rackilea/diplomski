public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.distribution_points);

            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);

            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

            cartPadgeNumber=findViewById(R.id.cartPadgeNumber);

            ///////////////////////////////////////////////////////////
            // Create an ArrayList of AndroidFlavor objects

            final ArrayList<Stores> stores = new ArrayList<Stores>();
            stores.add(new Stores("El Badry Serag Mall", R.drawable.badry_logo, R.drawable.ic_call_black_24dp, R.drawable.ic_directions_black_24dp));
            stores.add(new Stores("El Badry Maadi", R.drawable.badry_logo, R.drawable.ic_call_black_24dp, R.drawable.ic_directions_black_24dp));
            stores.add(new Stores("El Badry Hurghada", R.drawable.badry_logo, R.drawable.ic_call_black_24dp, R.drawable.ic_directions_black_24dp));
            stores.add(new Stores("Dose Mart Nasr City", R.drawable.dose_nasr_logo, R.drawable.ic_call_black_24dp, R.drawable.ic_directions_black_24dp));
            stores.add(new Stores("Dose Mart Heliopolis", R.drawable.dose_hel_logo, R.drawable.ic_call_black_24dp, R.drawable.ic_directions_black_24dp));
            stores.add(new Stores("Dose Mart Maadi", R.drawable.dose_maadi_logo, R.drawable.ic_call_black_24dp, R.drawable.ic_directions_black_24dp));
            stores.add(new Stores("ADAMS", R.drawable.adams_logo, R.drawable.ic_call_black_24dp, R.drawable.ic_directions_black_24dp));
            stores.add(new Stores("First Exit Maadi", R.drawable.first_exit_logo, R.drawable.ic_call_black_24dp, R.drawable.ic_directions_black_24dp));
            stores.add(new Stores("First Exit New Cairo", R.drawable.first_exit_logo, R.drawable.ic_call_black_24dp, R.drawable.ic_directions_black_24dp));
            stores.add(new Stores("Mahala Vape Club", R.drawable.mahala_logo, R.drawable.ic_call_black_24dp, R.drawable.ic_directions_black_24dp));
            stores.add(new Stores("El Kot Vape El Zamalik", R.drawable.kot_logo, R.drawable.ic_call_black_24dp, R.drawable.ic_directions_black_24dp));
            stores.add(new Stores("Ghost Vape Heliopolis", R.drawable.ghost_logo, R.drawable.ic_call_black_24dp, R.drawable.ic_directions_black_24dp));
            stores.add(new Stores("Ghost Vape", R.drawable.ghost_logo, R.drawable.ic_call_black_24dp, R.drawable.ic_directions_black_24dp));
            stores.add(new Stores("The Hub El Mohandeseen", R.drawable.hub_logo, R.drawable.ic_call_black_24dp, R.drawable.ic_directions_black_24dp));
            stores.add(new Stores("The Hub El Dokki", R.drawable.hub_logo, R.drawable.ic_call_black_24dp, R.drawable.ic_directions_black_24dp));
            stores.add(new Stores("The Hub El Embaba", R.drawable.hub_logo, R.drawable.ic_call_black_24dp, R.drawable.ic_directions_black_24dp));
            stores.add(new Stores("Mashro3 Mazah", R.drawable.mashro3_mazag_logo, R.drawable.ic_call_black_24dp, R.drawable.ic_directions_black_24dp));
            stores.add(new Stores("Cloud House", R.drawable.cloud_house_logo, R.drawable.ic_call_black_24dp, R.drawable.ic_directions_black_24dp));
            stores.add(new Stores("Cloud Cafe & Restaurant", R.drawable.cloud_cafe_logo, R.drawable.ic_call_black_24dp, R.drawable.ic_directions_black_24dp));
            stores.add(new Stores("King Vape", R.drawable.king_logo, R.drawable.ic_call_black_24dp, R.drawable.ic_directions_black_24dp));
            stores.add(new Stores("City Clouds", R.drawable.city_logo, R.drawable.ic_call_black_24dp, R.drawable.ic_directions_black_24dp));
            stores.add(new Stores("Fog Vape", R.drawable.fog_logo, R.drawable.ic_call_black_24dp, R.drawable.ic_directions_black_24dp));
            stores.add(new Stores("O2 Vape", R.drawable.o2_logo, R.drawable.ic_call_black_24dp, R.drawable.ic_directions_black_24dp));
            stores.add(new Stores("Zag Vape", R.drawable.zagvap_logo, R.drawable.ic_call_black_24dp, R.drawable.ic_directions_black_24dp));
            stores.add(new Stores("Awel Abbas 1", R.drawable.awel_abas_logo, R.drawable.ic_call_black_24dp, R.drawable.ic_directions_black_24dp));
            stores.add(new Stores("Awel Abbas 2", R.drawable.awel_abas_logo, R.drawable.ic_call_black_24dp, R.drawable.ic_directions_black_24dp));
            stores.add(new Stores("Roma Store October City ", R.drawable.roma_logo, R.drawable.ic_call_black_24dp, R.drawable.ic_directions_black_24dp));
            stores.add(new Stores("Roma Store El Haram ", R.drawable.roma_logo, R.drawable.ic_call_black_24dp, R.drawable.ic_directions_black_24dp));
            stores.add(new Stores("Miami Vape", R.drawable.miami_logo, R.drawable.ic_call_black_24dp, R.drawable.ic_directions_black_24dp));

           final ListView storesListView = (ListView) findViewById(R.id.stores_listView);


        StoresAdapter adapter = new StoresAdapter(this, stores, new StoresAdapter.OnclickListener() {
            @Override
            public void onMapButtonClick(int position) {
                Toast.makeText(MainActivity.this, "this is click on map "+position,Toast.LENGTH_LONG).show();
            }

            @Override
            public void onCallButtonClick(int position) {
                Toast.makeText(MainActivity.this, "this is click on call "+position,Toast.LENGTH_LONG).show();
            }
        });

        final ListView storesListView = (ListView) findViewById(R.id.stores_listView);
        storesListView.setAdapter(adapter);



    }

}