public class SearchActivity extends Activity {
    ArrayAdapter<String> adapter2;
    String city_values[];

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_layout);

        final Spinner zipspinner = (Spinner) findViewById(R.id.zipspinner);
        final Spinner cityspinner = (Spinner) findViewById(R.id.cityspinner);

        String city_values[] = new String[]{"Please select a state."};
        adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, city_values);
        adapter2.setDropDownViewResource(R.layout.city_spinner_layout);
        cityspinner.setAdapter(adapter2);

        JSONArray jsonArray;
        final JSONArray cityArray;

        try {
            String spinnerContentType = "state";
            String spinnerURL = "getStoreState.php";
            String spinner_data = DataCall.getJSON(spinnerURL, spinnerContentType);

            jsonArray = new JSONArray(spinner_data);

            final String[] array_spinner = new String[jsonArray.length()];

            for (int i = 0; i < jsonArray.length(); i++) {
                String styleValue = jsonArray.getJSONArray(i).getString(0);
                array_spinner[i] = styleValue;
            }

            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, array_spinner);
            adapter.setDropDownViewResource(R.layout.state_spinner_layout);
            zipspinner.setAdapter(adapter);
            zipspinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

                public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                    int item = zipspinner.getSelectedItemPosition();
                    String item_value = array_spinner[item];
                    String spinnerContentType = "city";
                    String spinnerURL = "getStoreCity.php?state=" + item_value;
                    String city_data = DataCall.getJSON(spinnerURL, spinnerContentType);
                    cityArray = new JSONArray(city_data);               //The final local variable cityArray cannot be assigned, since it is defined in an enclosing type

                    final String[] city_spinner = new String[cityArray.length()];


                    for (int i = 0; i < cityArray.length(); i++) {
                        String styleValue = cityArray.getJSONArray(i).getString(0); //Unhandled exception type JSONException                
                        city_spinner[i] = styleValue;
                    }

                    city_values = city_spinner; //Unhandled exception type JSONException
                    adapter2.notifyDataSetChanged();
                }

                public void onNothingSelected(AdapterView parent {
                    // Do nothing.
                }
            });
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}