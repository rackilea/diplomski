void add(String json) {
  try {
    X x = mapper.readValue(json, X.class);
    return null;
  } catch (JsonParseException e) {
    throw new RuntimeException(e);
  } catch (JsonMappingException e) {
    throw new RuntimeException(e);
  } catch (IOException e) {
    throw new RuntimeException(e);
  }
}