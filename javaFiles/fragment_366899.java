Type listType = new TypeToken<LinkedList>() {}.getType();
List target = new LinkedList();
target.add("blah");

Gson gson = new Gson();
String json = gson.toJson(target, listType);
List target2 = gson.fromJson(json, listType);