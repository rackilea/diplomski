JSONArray msg = (JSONArray) xmlJSONObj.get("content");
Iterator<String> iterator = msg.iterator();

while (iterator.hasNext()) {
    System.out.println(iterator.next());
}