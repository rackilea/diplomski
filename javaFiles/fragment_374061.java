String listToJson(List<String> list) {
  JsArrayString array = (JsArrayString) JsArrayString.createArray();

  for (int i = 0; i < list.size(); i++) {
    array.set(i, list.get(i));
  }

  return new JSONArray(array).toString();
}

List<String> jsonToList(String json) {
  JsArrayString jas = JsonUtils.safeEval(json);
  List<String> list = new ArrayList<String>();

  for (int i = 0; i < jas.length(); i++) {
    list.add(jas.get(i));
  }

  return list;
}

void myEntryPoint() {
  ArrayList myList = new ArrayList();
  myList.add("cake");
  myList.add("pie");
  myList.add("ice cream");

  Storage.getLocalStorageIfSupported().
      setItem("myKey", listToJson(myList));

  // ...

  ArrayList otherList =
      jsonToList(Storage.getLocalStorageIfSupported().
          getItem("myKey"));
}