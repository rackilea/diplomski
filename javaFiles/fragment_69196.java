public Map<String, String> test() {

    Map<String, String> result = items.stream().collect(Collectors.toMap(Item::getValue, Item::getType)); //Converts List items to Map

    System.out.println("Result  : " + result);

    JSONObject json = new JSONObject(result); //Converts MAP to JsonObject

    System.out.println("JSON : " + json); //prints {"firstname":"abc","lastname":"pqr","id":"1"}
    return result;
}