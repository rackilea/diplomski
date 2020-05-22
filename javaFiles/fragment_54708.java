String ID_PREFIX = "^!^ID^!^";
String USERNAME_PREFIX = "^!^USERNAME^!^";
String FIRSTNAME_PREFIX = "^!^FIRSTNAME^!^";
Map<String,Person> personMap = new HashMap<String,Person>();

//add a person
void addPersonToMap(Person person)
{
    personMap.put(ID_PREFIX+person.id, person);
    personMap.put(USERNAME_PREFIX+person.username, person);
    personMap.put(FIRSTNAME_PREFIX+person.firstname, person);
}

//search person
Person findPersonByID(long id)
{
    return personMap.get(ID_PREFIX+id);
}

Person findPersonByUsername(String username)
{
    return personMap.get(USERNAME_PREFIX+username);
}

//or a more generic version:
//Person foundPerson = findPersonByAttribute(FIRSTNAME_PREFIX, "mike");
Person findPersonByAttribute(String attr, String attr_value)
{
    return personMap.get(attr+attr_value);
}