public class Hotels extends AppCompatActivity {

        Hotel hotels[];

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_hotels);
            GridLayout glHotels=(GridLayout) findViewById(R.id.glHotels);
            new HotelInfo().execute();

        }

        private class HotelInfo extends AsyncTask<Void,Void,Void>{

                @Override
                protected Void doInBackground(Void... params) {
                    ServiceManager service=new ServiceManager(getApplicationContext());
                    hotels=service.GetHotels(1);
                    return null;
                }

                @Override
                protected void onPostExecute(Void aVoid) {
                    super.onPostExecute(aVoid);
                    if(hotels != null){
                        for (int i=0; i<hotels.length; i++) {
                            glHotels.addView(hotels[i]);
                        }
                    }
                }
            }
}