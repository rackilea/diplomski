PersonRepository personRepository = mock(PersonRepository.class);

@TestSubject
PersonService personService = new PersonService(): 

@Test
public void unitTest() {
    personService.setPersonRepository(personRepository);
    Person person = new Person(1L);
    Person person2 = new Person(1L);

    when(personRepository.returnPerson(1L)).thenReturn(person2); //expect a fetch, return a "fetched" person;

    personService.deleteFromPerson(person);

    verify(personRepository, times(1)).delete(person2); //pretty sure it is verify after call
}