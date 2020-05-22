//this is your address-book with unique User-Name
private static final HashMap<String, AddressBookEntry> addressBook = new HashMap<String, AddressBookEntry>();
...
...
boolean addEntry(){
    boolean isNewEntry = true;
    //getNonBlankInput should check for valid name
    String name = getNonBlankInput("Enter Name: ");
    if(!addressBook.containsKey(name.toLowerCase())){
        AddressBookEntry entry  = new AddressBookEntry();
        entry.setName(name);
        entry.setAdd(getNonBlankInput("Enter Address: "));
        entry.setPhoneNo(getNonBlankInput("Enter Phone No.: "));
        entry.setEmail(getNonBlankInput("Enter E-mail Address: "));
        addressBook.put(name.toLowerCase(), entry);
    }else{
        isNewEntry = false;
    }
    return isNewEntry;

}