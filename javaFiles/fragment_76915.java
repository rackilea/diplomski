List<WeatherLocation> savedList = dbHelper.getAllWeatherLocations();
    //savedList.add(new WeatherLocation(72, "04005", "Biddeford"));
    if(savedList.size() > 0){
        mWeatherLocationAdapter = new WeatherLocationAdapter(savedList, this, R.layout.view_weather_location);
        lvLocations.setAdapter(mWeatherLocationAdapter);
    }