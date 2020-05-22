boolean isValueEmpty(JsonValue v) {
  if (v == null) {
    return true; // or you may throw an exception, for example
  }
  switch(v.getValueType()) {
    case NULL:
      return true; // same as with Java null, we assume that it is Empty
    case ARRAY: 
      return ((JsonArray) v).isEmpty();
      // additionally, you can say that empty array is array with only empty elements
      // this means a check like this:
      // return ((JsonArray v).stream().allMatch(isValueEmpty); // recurse
    case OBJECT:
      return ((JsonObject v).isEmpty();
    case STRING:
      // optionally: if you want to treat '' as empty
      return ((JsonString v).getString().isEmpty();
    default:
      return false; // to my knowledge, no other Json types can be empty
  }
}