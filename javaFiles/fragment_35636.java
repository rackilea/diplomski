for (int i = 0; i < 5; i++) {         
    Forecast forecast = new Forecast();  // Line that you missed
    JSONObject jsonobject2=jsonArray.getJSONObject(i); 
    // your code goes here
    forecastList.add(forecast);
}