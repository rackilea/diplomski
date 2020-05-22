protected void onCreate(Bundle bundle) {
    super.onCreate(savedInstanceState);

    Intent intent = getIntent();
    HashMap<String, String> hashMap = (HashMap<String, String>)intent.getSerializableExtra("data");
    String lat = hashMap.get("Coord_LAT");
    String longi = hashMap.get("Coord_LONG");
}