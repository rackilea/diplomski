JSONObject primary_contact = new JSONObject(s);
 String s1 = primary_contact.getString("cities");
 JSONObject primary_contact1 = new JSONObject(s1);
 String s2 = primary_contact1.getString("city");


 List<City> citiesList = new ObjectMapper().readValue(s2, new TypeReference<List<City>>() { });