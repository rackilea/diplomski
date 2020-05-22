while(rs.next()){
    String jsonInString= rs.getString("fls");
    JSONDeserializer<ProcessInputs> der = new JSONDeserializer<ProcessInputs>();
    // exception is here, right? der.deserialize(String) is giving you a Map!!
    Map<String,Input> fls = der.deserialize(jsonInString);
}