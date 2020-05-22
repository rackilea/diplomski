public static void main(String [] args){
    Person one = new Person("Alice");
    Person two = new Person("Bob");

    List<Person> people = new ArrayList<Person>();
    people.add(one);
    people.add(two); 

    Gson gson = new Gson();
    JsonElement je = gson.toJsonTree(people);
    JsonObject jo = new JsonObject();
    jo.add("person", je);
    System.out.println(jo.toString()); //prints {"person":[{"name": "Alice"},{"name": "Bob"}]}
}