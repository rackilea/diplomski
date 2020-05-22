class Example extends WoblyImpl {
  @WoblyField(id = 0)
  List<Map<Integer, String>> array;

  public void setArray(JSONArray json) {
    array = (List)json;
  }
}