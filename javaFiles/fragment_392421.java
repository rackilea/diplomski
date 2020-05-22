public void editContact() {
    String editOption;
    System.out.print("HOW WOULD YOU LIKE TO EDIT A CONTACT: ");
    System.out.println("\tdelete  --> Delete a contact");
    System.out.println("\tchange  --> edit or replace a contact");
    editOption = scan.nextLine();

    if(editOption.equalsIgnoreCase("delete")) {
        Contact contact = findContact(temp);
        if (contact != null) {
            card.remove(contact);
            writeContact();
            readContact();
        }
    }   
}