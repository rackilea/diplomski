Map<Person, TelephoneNumber> contactList = getContactList();
Map<Person, TelephoneNumber> localContacts = new HashMap<Person, TelephoneNumber>(contactList);

for ( Iterator<TelephoneNumber> valuesIt = localContacts.values().iterator(); valuesIt.hasNext(); ){
    TelephoneNumber number = valuesIt.next();
    if ( !number.getAreaCode().equals(myAreaCode) ) {
        valuesIt.remove();
    }
}