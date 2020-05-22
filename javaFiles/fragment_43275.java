public <T> T getMessage(BufferedReader r, TypeToken<T> typeToken){
  try {
    return g.fromJson(r, typeToken.getType());
  } catch (final JsonSyntaxException e) {
    LOGGER.info("Error in Json format", e);
  } catch (final JsonParseException e) {
    LOGGER.info("Error in parsing Json", e);
  }
  return null;
}