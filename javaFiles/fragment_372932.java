public void removeMember()throws FileNotFoundException {
    System.out.println("Which MemberPlayer are you looking to remove?:");
    System.out.print("Input first name: ");
    String fName1 = input.nextLine().toUpperCase();
    System.out.print("Input last name: ");
    String lName2 = input.nextLine().toUpperCase();

    for (MemberPlayer m : memberlist){

        if (m.getFirstName().equals(fName1) & m.getLastName().equals(lName2)) {
            System.out.println();
            memberlist.remove(m);
            System.out.println("You removed: "+m.getFirstName()+" "+m.getLastName());
            System.out.println();
            saveMember();
            break;
        } else {
            System.out.println();
            System.out.println("This MemberPlayer doesn't exist");
            System.out.println();
            break;
        }
    }
}