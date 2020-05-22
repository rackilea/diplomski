public class WeatherTask extends AsyncTask<String, Void, String[]> {

    @Override
    protected String[] doInBackground(String... params) {
        String city = params[0];
        String state = params[1];

        city = city.replaceAll(" ", "_");
        // construct post URL
        final String GET_WEATHER_URL = WEATHER_URL + state + "/" + city
                + ".json";
        String request = GET_WEATHER_URL;
        HttpResponse rp = null;
        JSONObject jObject = null;
        try {
            HttpClient httpclient = new DefaultHttpClient();
            httpclient.getParams().setParameter(
                    CoreProtocolPNames.PROTOCOL_VERSION,
                    HttpVersion.HTTP_1_1);
            HttpGet request1 = new HttpGet(
                    "http://api.wunderground.com/api/key/conditions/q/CA/Anuradhapura.json");
            HttpResponse response = httpclient.execute(request1);
            HttpEntity resEntity = response.getEntity();
            String _response = EntityUtils.toString(resEntity);
            jObject = new JSONObject(_response);
            JSONObject current_observation = jObject
                    .getJSONObject("current_observation");
            String temperature_string = current_observation
                    .getString("temperature_string");
            String weather = current_observation.getString("weather");
            Log.i("..............", "" + weather);
            Log.i("..............", "" + temperature_string);
            String icon_url = current_observation.getString("icon_url");
            String weather_icon = get_weather_icon(icon_url);
            String[] out = new String[]{weather,weather_icon,temperature_string};
            return out;
        } catch (Exception exception) {

        }
        return null;
    }

    @Override
    protected void onPostExecute(String[] result) {
        if(result != null) {
            String weather = result[0];
            String weather_icon = result[1];
            String temperature_string = result[2];
        }
    }
}