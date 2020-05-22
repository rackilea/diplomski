@Test
public void testPersonCompleteName() throws Exception {

    Person person = Person.newBuilder()
            .setFirstName("John").setLastName("Atanasoff").build();

    Assert.assertEquals("John Atanasoff", person.getCompleteName());
}