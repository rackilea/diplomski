@Override
public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
    String bus = (String) getItem(position);
    DbHandler db = new DbHandler(getApplicationContext());
    List<String> BusRouteList = db.getBusRoute(bus);
    ArrayAdapter<String> lvAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, BusRouteList);
    listView.setAdapter(lvAdapter);
}