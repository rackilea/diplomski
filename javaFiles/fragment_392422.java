public Contact findContact() {
    Contact find = null;
    System.out.println("Enter the LAST NAME of the contact you'd like to find: ");
    String tempLastName = scan.nextLine();
    for (Contact temp : card) {
        if (temp.getLastName().equalsIgnoreCase(tempLastName)) {
            System.out.println("\nCONTACT FOUND:");
            System.out.println(temp);
            find = temp;
            break;
        }
    }
    if (find == null) {
        System.out.println("Sorry but " + tempLastName + " is not located in this address book");
    }
    return find;
}