//Compare the last hour with the current hour
if(current_hour <= hour) {
    ArrayList<Weather> weather_list= sql_open_helper.addWeatherToList(db);
    MyArrayAdapter myArrayAdapter = new MyArrayAdapter(this, weather_list,false);
    ListView l = (ListView) findViewById(R.id.listView);
    l.setAdapter(myArrayAdapter);
}


else {
    Bg_task bg_task = new Bg_task(this);
    bg_task.execute();
}