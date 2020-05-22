public class App {
    public static void main(String[] args) {
        // Your JSON string
        String jsonString = "{\"City A\":{\"Position\":{\"Longitude\":9.96233,\"Latitude\":49.80404}},\"City B\":{\"Position\":{\"Longitude\":6.11499,\"Latitude\":50.76891}},\"City C\":{\"Position\":{\"Longitude\":6.80592,\"Latitude\":51.53548}},\"City D\":{\"Position\":{\"Longitude\":9.50523,\"Latitude\":51.31991}},\"City E\":{\"Position\":{\"Longitude\":9.66089,\"Latitude\":48.70158}},\"City F\":{\"Position\":{\"Longitude\":9.93368,\"Latitude\":53.55608}},\"City G\":{\"Position\":{\"Longitude\":11.56122,\"Latitude\":48.14496}},\"City H\":{\"Position\":{\"Longitude\":13.34253,\"Latitude\":52.5319}},\"City I\":{\"Position\":{\"Longitude\":6.11327,\"Latitude\":50.77715}},\"City J\":{\"Position\":{\"Longitude\":13.36671,\"Latitude\":52.54344}}}";
        JSONObject jsonObj = new JSONObject(jsonString);
        List<City> cities = new ArrayList<>(); // The arraylist that will hold the cities

        // A JSON array with the the names of all the cities
        JSONArray cityNames = jsonObj.names();

        for(int i = 0; i < jsonObj.length(); i++) {
            String cityName = cityNames.getString(i);
            JSONObject jsonCity = jsonObj.getJSONObject(cityName);
            JSONObject jsonPosition = jsonCity.getJSONObject("Position");

            cities.add(new City(cityName, jsonPosition.getDouble("Latitude"), jsonPosition.getDouble("Longitude")));
        }

        Collections.sort(cities); // Sort the cities' arraylist by city name
        cities.forEach(System.out::println); // Print the cities
    }

}