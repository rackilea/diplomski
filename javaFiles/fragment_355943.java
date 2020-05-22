public static void main(String[] args) throws IOException {

    ObjectMapper mapper = new ObjectMapper();
    JsonFactory factory = new JsonFactory(mapper);

    JsonParser parser = factory.createParser(new File("config.json"));
    // factory.createParser(String) and many other overload methods
    // available, byte[], char[], InputStream etc.

    Iterator<Person> persons = parser.readValuesAs(Person.class);
    while(persons.hasNext()) {
        Person p = persons.next();
        System.out.printf("%s: %d%n", p.getName(), p.getAge());
    }
}