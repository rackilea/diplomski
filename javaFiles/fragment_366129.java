@Test
public void integrationTestForAddAndDelete() {
    Person person = createDummyPersonForInsertion(); //static method that creates a test Person for you
    Person comparePerson;
    //make sure we haven't added the person yet
    Assert.assertNull(personService.getPerson(person));

    //add the Person
    comparePerson = personService.addPerson(person);
    Assert.assertNotNull(personService.getPerson(person));
    //add a rigorous compare method to make sure contents are the same, i.e. nothing is lost or transmuted incorrectly, ignoring ID if that is autogen
    //alternatively, you can create a unit test just for Person
    Assert.assertEquals(person, comparePerson); 

    //remove the Person
    personService.deleteFromPerson(person);
    Assert.assertNull(personService.getPerson(person));

    //test for exception handling when you try to remove a non-existent person;
    personService.deleteFromPerson(person);

    //test for exception handling when you try to remove null
    personService.deleteFromPerson(null);
}