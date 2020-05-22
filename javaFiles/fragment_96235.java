protected void onCreate(Bundle savedInstanceState) {
     super.onCreate(savedInstanceState);

     // will return the default value true if never been set before
     if (PreferencesData.getBoolean(this, "showGuide", true) {
         startActivity(new Intent(MainActivity.this, GuideActivity.class));

         // you can do this from the last step of your guide instead
         // to make sure that the guide is shown again if user 
         // quit before completing it

         PreferencesData.saveBoolean(this, "showGuide", false);

         finish();
     } else {
          // continue application
          setContentView(R.id.yourlayout);
          ...
     }
 }