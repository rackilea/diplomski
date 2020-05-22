public static void main(String[] args) {
    // TODO Auto-generated method stub
    String input = "{\"parent\": {\"s\": \"string\",\"childA\":{\"listString\": [\"ssssa\", \"a\"]}}}";
    Gson gsonInstance = null;

    gsonInstance = new GsonBuilder().create();

    Parent p = gsonInstance.fromJson(input, Parent.class);

    Map<String, JsonElement> parentMap = p.getParent();
    Set<String> keyMap = parentMap.keySet();

    Iterator<String> iter = keyMap.iterator();
    while(iter.hasNext()){
        String name = iter.next();
        if(name.matches("child(.*)")){
            System.out.println(parentMap.get(name));
            // do your logic
        }
        if (keyMap.contains("listString")){
            List<String> listString = getListString(parentMap.get("listString"));
            System.out.println(listString.toString());
        }
    }

}

public static List<String> getListString(JsonElement list){
    Type listType = new TypeToken<List<String>>() {}.getType();
    List<String> listString = new Gson().fromJson(list, listType);
    return listString;
}