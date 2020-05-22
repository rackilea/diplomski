public static <T> T toPOJO(String json, Class<T> type) {

    try {

        return JSON_MAPPER.readValue(json, type);

    } catch (JsonParseException e) {
        e.printStackTrace();
    } catch (JsonMappingException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    }
    return null;
}