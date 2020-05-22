public class MainActivity extends AppCompatActivity implements PlaceInterface{

     @Override
     protected void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_main);

         // your code...

         // calling the AsyncTask and send reference of the interface on it
         new PlacesDisplayTask(this).execute();  // something like this

     }


     @Override
     public void myPlaceList(ArrayList<NearbyPlaceModel>   nearbyPlaceModelArrayList) {
         ListView nearby_place = (ListView)  findViewById(R.id.itemListView);
         ListAdapter customAdapter = new ListAdapter(this, R.layout.nearby_place_listview, nearbyPlaceModelArrayList);
         nearby_place.setAdapter(customAdapter);
     }
}