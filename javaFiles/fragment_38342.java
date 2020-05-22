@Test
public void versioning() {
    Person person = new Person();
    person.setName("Davide");
    XStream xStream = new XStream(new DomDriver());
    xStream.registerConverter(new PersonConverter());
    xStream.alias("person", Person.class);
    System.out.println(xStream.toXML(person));
}