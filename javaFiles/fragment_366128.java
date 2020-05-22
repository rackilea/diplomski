@Mock
PersonRepository personRepository; //assuming it is autowired

@TestSubject
PersonService personService = new PersonService(): 

@Test
public void unitTest() {
    Person person = new Person(1L);
    Person person2 = new Person(1L);

    EasyMock.expect(personRepository.returnPerson(1L)).andReturn(person2); //expect a fetch, return a "fetched" person;
    personRepository.delete(person2);
    EasyMock.expectLastCall(); //expect a delete for person2 we plan to delete
    replayAll();

    personService.deleteFromPerson(person);

    verifyAll(); //make sure everything was called
}