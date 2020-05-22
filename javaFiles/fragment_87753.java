public static final String MyPREFERENCES = "banner_pref" ;
SharedPreferences SharedP;

protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    // load sharedpref value 
    SharedP = getSharedPreferences("banner_pref", MainHelloballi.MODE_PRIVATE);
    Boolean myValue = SharedP.getBoolean("banner_pref", true); // default: true

    // load layout, we just need it anyway
    bannerfull = (RelativeLayout) findViewById(R.id.banner_full);

    // if true, show it
    if (myValue == true) {
        bannerfull.setVisibility(View.VISIBLE);
        // ok, now switch value to 'false' and commit to SharedP
        editor = SharedP.edit();
        editor.putBoolean("banner_pref", false);
        editor.commit();
    }
    // if false, hide it
    else {
        bannerfull.setVisibility(View.GONE);
    }
}