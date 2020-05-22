public class Client {

    static final String REST_URI = "http://localhost:8080/springrest/rest/";
    static final String CITIES = "cities";
    static final String CITIES_BHUVAN = "cities/bhuvan";
    static final String BHUVAN = "bhuvan";
    static final String BHUVAN_BHUVAN = "bhuvan/bhuvan";

    public static void main(String[] args) throws JSONException {

        String s = "";

        WebClient plainAddClient = WebClient.create(REST_URI);
        plainAddClient.path(CITIES).accept("application/json");
        s = plainAddClient.get(String.class);
        try {

            JSONObject primary_contact = new JSONObject(s);
            String s1 = primary_contact.getString("cities");
            JSONObject primary_contact1 = new JSONObject(s1);
            String s2 = primary_contact1.getString("city");


            List<City> citiesList = new ObjectMapper().readValue(s2, new TypeReference<List<City>>() { });

            for(City city : citiesList) {
                System.out.println("----------START---------");
                System.out.println(city.getName());
                System.out.println(city.getPopulation());
                System.out.println(city.getTelephonecode());
                System.out.println("---------END----------");
            }

        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        WebClient xmlAddClient = WebClient.create(REST_URI);
        xmlAddClient.path(CITIES_BHUVAN).accept("application/json");
        s = xmlAddClient.get(String.class);
        System.out.println(s);

        WebClient plainSubClient = WebClient.create(REST_URI);
        plainSubClient.path(BHUVAN).accept("application/json");
        s = plainSubClient.get(String.class);
        System.out.println(s);

        WebClient xmlSubClient = WebClient.create(REST_URI);
        xmlSubClient.path(BHUVAN_BHUVAN).accept("application/json");
        s = xmlSubClient.get(String.class);
        System.out.println(s);
    }
}