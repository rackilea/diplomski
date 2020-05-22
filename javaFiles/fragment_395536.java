final Gson gson = new GsonBuilder()
        .serializeNulls()
        .create();
final Person person = new Person();
person.name = "John";
final PersonDto personDto = person.fax == null
        ? new PersonDto(person)
        : new PersonDtoWithFax(person);
System.out.println(gson.toJson(personDto));