// map to keep each country and its cities
final HashMap<String, ArrayList<String>> data = new HashMap<>();
// add your json array
JSONArray array;
try {
    array = new JSONArray("");
} catch (JSONException e) {
    e.printStackTrace();
    return;
}
try {
    for (int i = 0; i < array.length(); i++) {
        JSONObject item = array.getJSONObject(i);

        String country = item.getString("country");

        // get the country from the map according to the country in json
        ArrayList<String> dataList = data.get(country);
        // if the list is null "the map doesn't have the list", create new one and add it to the map
        // else add the city to the country list
        if (dataList == null) {
            dataList = new ArrayList<>();
            data.put(country, dataList);
        }
        dataList.add(item.getString("city"));
    }
} catch (JSONException e) {
    e.printStackTrace();
}

final ArrayList<String> citiesList = new ArrayList<>();
final ArrayAdapter<String> citiesAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, citiesList);

Spinner countriesSpinner = (Spinner) findViewById(R.id.spCountries);
// create the countries list to add it to the countries spinner
final ArrayList<String> countriesList = new ArrayList<>();
countriesList.add("india");
countriesList.add("england");
countriesList.add("australia");
countriesSpinner.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, countriesList));
countriesSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // get the selected country from spinner
        String selectedCountry = countriesList.get(position);
        // get the cities in the selected country
        ArrayList<String> cities = data.get(selectedCountry);

        // clear the list then add new cities
        citiesList.clear();
        for (String city : cities)
            citiesList.add(city);
        citiesAdapter.notifyDataSetChanged();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
});

Spinner citiesSpinner = (Spinner) findViewById(R.id.spCities);
citiesSpinner.setAdapter(citiesAdapter);