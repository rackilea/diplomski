Organization organization = ...
List<Person> people = ...
ob.put(organization)
for (Person person: people) {
    person.organizationKey = organization.getKey();
    ob.put(person);
    organization.contactPeopleKeys.add(person.getKey());
}
ob.put(organization)