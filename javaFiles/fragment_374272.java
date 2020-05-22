public  class ResultsActivity extends AppCompatActivity
        implements MapFragment.MarkerClickCB
....
   //previous fragment info//  
...
     public void onMarkerSelected(String near, GoogePlaces googPlace) {

            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            PlaceFragment fragment = PlaceFragment.newInstance(googPlace);
            ft.replace(R.id.search_frag, fragment);
            ft.commit();
        }