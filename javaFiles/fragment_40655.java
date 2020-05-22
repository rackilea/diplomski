private static class CityWeatherData extends AsyncTask<String,Void,String> {

        private WeakReference<MainActivity> mainActivity;    

        public CityWeatherData(MainActivity context) {   
            mainActivity = new WeakReference<>(context);            
        }

        @Override
        protected String doInBackground(String... urls) {
          ....
        }


        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            MainActivity cxt = mainActivity.get();
            if (cxt != null) {

            //Create JSON object from result
        try {
            JSONObject jsonObject = new JSONObject(result);
            JSONObject weatherData = new JSONObject(jsonObject.getString("main"));
            //The data we are interesed in is located after "main"

            //Get temp from main
            double temp = Double.parseDouble(weatherData.getString("temp"));

            //Temp is given i Kelvin so it needs to be converted to Celcius
            int tempInt = (int) (temp -273.15);

            //Get city name
            String placeName = jsonObject.getString("name");

            //Get description
            String weatherDescription = jsonObject.getString("description");

            //Get humidity
            double humidityValue = Double.parseDouble(weatherData.getString("humidity"));

            Intent sendDataIntent = new Intent(cxt, CityDetailsActivity.class);
            sendDataIntent.putExtra("tempData", tempInt);
            sendDataIntent.putExtra("cityNameData", placeName);
            sendDataIntent.putExtra("humidityData", humidityValue);
            sendDataIntent.putExtra("descriptionData", weatherDescription);
            startActivity(sendDataIntent);

        } catch (Exception e) {
            e.printStackTrace();
        }
      }
    }
}