@Test
public void testAddOneContact() {
    final Contact contact = this.context.mock(Contact.class);

    this.addressBook.addContact(contact);

    assertTrue("Object added to list", this.addressBook.getNumberOfContacts() == 1);  

    //assuming that Contact class implements the equals() method you can test that the contact
    //added is indeed the one that you passed in
    assertTrue(addressBook.get(0).equals(contact));      
}



//the below test ensures that there is exception handling mechanism within your library code
@Test
@Expected(IllegalArgumentException.class)
public void testShouldThrowWhenContactIsNull()
{
    this.addressBook.addContact(null);
}