// Other menu code here...
System.out.println("Query Contacts: Enter 3");
System.out.println("To Quit: Enter 4");

// Other code here...

// Bring up sub-menu
// Feel free to extend to return to main menu etc.
if (type == 3){
    while (true) {
       System.out.println("List Contacts: Enter 1");
       System.out.println("Display Contact Details: Enter 2");
       System.out.println("To Quit: Enter 3");

       // If you need, store in another int etc.
       type = input1.nextInt();

       //Print full name of each Contact.
       if (type == 1) {
          for (Contact namecontact: contacts) {
             System.out.println(namecontact.displayFullName());
             System.out.println();
          }
       }
       //Print contact details for selected contact.
       else if(type == 2){
          System.out.println("Enter a Contact ID to display Contact Details: ");
          Scanner input2 = new Scanner(System.in);
          String soughtID;
          soughtID = input2.nextLine();

          for (Contact showcontact1: contacts) {
              // Although correct, I'd recommend you add a braces for if statements
              // Saving a line for a closing brace is not generally worth it
              if (showcontact1.displayId().equals(soughtID))
                 System.out.println(showcontact1.displayContact());
              System.out.println();
          }
       } else if (type == 3) {
          break;
       }
    }
}