mCurrentWeather = getCurrentDetails(jsonData);
 mDailyWeather = getDailyForecast(jsonData);
 runOnUiThread(new Runnable() {
     @Override
     public void run() {
         updateDisplay();
     }
 });