public void addContact(Contact contact) throws IllegalArgumentException
{
    if(contact == null)
    {
           //throw an exception after logging that contact is null
           throw new IllegalArgumentException("Passed in contact cannot be null!!")
    }
    this.contactsList.add(contact);
}