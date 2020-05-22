URL myURL = new URL("http://ws.geonames.org/countryCode?lat=47.03&lng=10.2");
URLConnection serviceConnection = myURL.openConnection();
BufferedReader in = new BufferedReader(new InputStreamReader(
                               serviceConnection.getInputStream()));

List<String> response =new ArrayList<String>();