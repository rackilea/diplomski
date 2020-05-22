public Map<String,Optional<String>> getMap(){
  return ImmutableMap.<String,Optional<String>>builder()
    .put("FOO",Optional.<String>ofNullable(getFooType()))
    .put("BAR", Optional.<String>ofNullable(getBarType()))
    .build();
}