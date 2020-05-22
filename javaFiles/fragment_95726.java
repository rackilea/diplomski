private class weatherTask extends AsyncTask<Void, Void, String> { // has result now
        @Override
        protected Void doInBackground(Void... voids) {

            XmlPullParserFactory parserFactory;
            try {
                parserFactory = XmlPullParserFactory.newInstance();
                XmlPullParser parser = parserFactory.newPullParser();
                try {
                    InputStream is = new URL(URLT).openStream();
                    parser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
                    parser.setInput(is, null);

                    return processParsing(parser);

                } catch (IOException e) {
                    e.printStackTrace();
                }
            } catch (XmlPullParserException e) {
                e.printStackTrace();
            }

        }

        private String processParsing(XmlPullParser parser) throws IOException, XmlPullParserException{

            ArrayList<WeatherConditions> weather = new ArrayList<>();
            int eventType = parser.getEventType();
            WeatherConditions currentWeather = null;

            while(eventType != XmlPullParser.END_DOCUMENT){

                String sName = null;

                switch(eventType){
                    case XmlPullParser.START_TAG:
                        sName = parser.getName();

                        if ("root".equals(sName)){
                            currentWeather = new WeatherConditions();
                            weather.add(currentWeather);
                        }else if (currentWeather != null){
                            if ("name".equals(sName)){
                                currentWeather.name = parser.nextText();
                            }
                            else if ("wind_mph".equals(sName)){
                                currentWeather.wind_mph = parser.nextText();
                            }else if ("wind_kph".equals(sName)){
                                currentWeather.wind_kph = parser.nextText();
                            }else if ("temp_c".equals(sName)){
                                currentWeather.celsius = parser.nextText();
                            }else if ("feelsCelsius".equals(sName)){
                                currentWeather.feelsCelsius = parser.nextText();
                            }else if ("fahrenheit".equals(sName)){
                                currentWeather.fahrenheit = parser.nextText();
                            }else if ("feelsFahrenheit".equals(sName)){
                                currentWeather.feelsFahrenheit = parser.nextText();
                            }else if ("humidity".equals(sName)){
                                currentWeather.humidity = parser.nextText();
                            }else if ("text".equals(sName)){
                                currentWeather.condition_text = parser.nextText();
                            }
                        }
                        break;
                }

                eventType = parser.next();
            }

            return printWeather(weather);
        }

        private String printWeather(ArrayList<WeatherConditions> weather){

            StringBuilder builder = new StringBuilder();

            for (WeatherConditions weatherC : weather){

                builder.append(weatherC.name).append("\n").append(weatherC.wind_mph).append("\n").append(weatherC.wind_kph).append("\n").append(weatherC.celsius).append("\n").append(weatherC.feelsCelsius).
                        append("\n").append(weatherC.fahrenheit).append("\n").append(weatherC.feelsFahrenheit).append("\n").append(weatherC.humidity).append("\n").append(weatherC.condition_text).append("\n");

            }

            return builder.toString();
        }


        /// THIS METHOD ADDED
        @Override
        protected void onPostExecute(String result) {
            txt.setText(result);
        }
}