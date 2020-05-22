public boolean checkJsonCompatibility(String jsonStr, Class<?> valueType) throws JsonParseException, IOException {

        ObjectMapper mapper = new ObjectMapper();

        try {
            mapper.readValue(jsonStr, valueType);
            return true;
        } catch (JsonMappingException e) {
            return false;
        } 

    }