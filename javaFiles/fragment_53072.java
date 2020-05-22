// The junit error message will be in following format
// java.lang.AssertionError: arrays first differed at element [0]; expected:<{json}> but was:<{json}>
// So we get both source and target Json, and throw in the magic of gson library
// We compare them using method mentioned in link above.
// Now the new message that will be asserted contains message like below (assuming property 1 of the object is the mismatch)
// not equal: value differences={property1=("expected","actual")}

private static String getMessage(AssertionError e) throws IOException {
    String msg = e.getMessage();
    String sourceJson = msg.substring(msg.indexOf("expected:<") + 10, msg.indexOf("> but was:"));
    String targetJson = msg.substring(msg.lastIndexOf("but was:<") + 9, msg.lastIndexOf(">"));
    Gson g = new Gson();
    Type mapType = new TypeToken<Map<String, Object>>(){}.getType();
    Map<String, Object> firstMap = g.fromJson(sourceJson, mapType);
    Map<String, Object> secondMap = g.fromJson(targetJson, mapType);
    return Maps.difference(firstMap, secondMap).toString();
}