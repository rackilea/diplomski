@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_maps);

    MapFragment mapFragment = (MapFragment) getFragmentManager()
                .findFragmentById(R.id.map);
    mapFragment.getMapAsync(this);
}