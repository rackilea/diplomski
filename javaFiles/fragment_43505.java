@PatchMapping("/update")
public String updateOnlyIfFieldIsPresent(@RequestBody String requestString) throws JsonParseException, JsonMappingException, IOException {

    if (requestString.contains("\"name\"")) {
        ObjectMapper mapper = new ObjectMapper();
        Person person = mapper.readValue(requestString, Person.class);
        return "Success -" + person.getName();
    } else {
        return "Success - " + "name attribute not present in request body"; 
    }

}