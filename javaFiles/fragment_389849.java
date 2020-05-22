JSONObject loadObject( String filename ) {
  ...

  Object obj = parser.parse( xxx );
  if( obj instanceof JSONObject ) {
    return (JSONObject)obj;
  }
  else {
    throw new IllegalArgumentException( "json root is not a single object");
  }
}

JSONArray loadArray(String filename) {
  //similar to above
}