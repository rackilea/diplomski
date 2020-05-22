private <T> T deserialize(ObjectMapper mapper, Class<T> type, String jsonString) {
        T t = null;
        try {
            t = mapper.readValue(jsonString, type);
        } catch (UnrecognizedPropertyException  e) {
            //handle unrecognized string
        }catch (IOException  e) {
            //handle under errors
        }
        return t;
    }