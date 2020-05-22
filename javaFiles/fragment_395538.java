// Both Gson instances must have serializeNulls()
final Gson gson = new GsonBuilder()
        .serializeNulls()
        .create();
final Gson gsonWrapper = new GsonBuilder()
        .serializeNulls()
        .registerTypeAdapter(Person.class, getSpecialJsonSerializer(gson, singletonList("fax")))
        .create();
final Person person = new Person();
person.name = "John";
System.out.println(gsonWrapper.toJson(person));