public static final String LOG = hourlyWeather.class.getSimpleName();
    double test;
    RequestQueue mQuene;
    ArrayList<Weather> list;
    hourlyWeatherAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hourly_weather);
        mQuene =  Volley.newRequestQueue(this);

        list = new ArrayList<Weather>();
        adapter = new hourlyWeatherAdapter(this, list);

        ListView listView = (ListView) findViewById(R.id.weatherListView);
        listView.setAdapter(adapter);

        test();
    }

    public void test() {
        String url = "https://api.openweathermap.org/data/2.5/weather?lat=50.7578594&lon=16.2127653&units=metric&appid=ID";
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
            response -> {
                try {
                    JSONObject object = response.getJSONObject("main");
                    for (int i = 0; i<object.length(); i++){
                        test = object.getDouble("temp");
                    }
                    Log.i(LOG,String.valueOf(test));
                    list.add(new Weather(test));

                    // Update list
                    adapter.notifyDataSetChanged();

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }, Throwable::printStackTrace);
       mQuene.add(request);
    }
}