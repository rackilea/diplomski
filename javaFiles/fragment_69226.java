public interface AddressBookService {

    List<Person> getContacts();

    void addContact(Person contact);

    void deleteContact(Person person);

}