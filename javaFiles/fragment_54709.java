Map<String,List<Person>> personMap = new HashMap<String,List<Person>>();

//add a person
void addPersonToMap(Person person)
{
    insertPersonIntoMap(ID_PREFIX+person.id, person);
    insertPersonIntoMap(USERNAME_PREFIX+person.username, person);
    insertPersonIntoMap(FIRSTNAME_PREFIX+person.firstname, person);
}

//note that List contains no duplicates, so can be called multiple times for the same person.
void insertPersonIntoMap(String key, Person person)
{
    List<Person> personsList = personMap.get(key);
    if(personsList==null)
        personsList = new ArrayList<Person>();
    personsList.add(person);
    personMap.put(key,personsList);
}

//we know id is unique, so we can just get the only person in the list
Person findPersonByID(long id)
{
    List<Person> personList = personMap.get(ID_PREFIX+id);
    if(personList!=null)
        return personList.get(0);

    return null;
}

//get list of persons with firstname
List<Person> findPersonsByFirstName(String firstname)
{
    return personMap.get(FIRSTNAME_PREFIX+firstname);
}