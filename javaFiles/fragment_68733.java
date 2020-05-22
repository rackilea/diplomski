do { 
    System.out.println("Please enter one of the following options:\n1) Add customer\n2) Delete customer from room\n3 )View all empty rooms\n4) Find a customer\n5) Load program from text file\n6) Order rooms alphabetically\n7) Store program into text file\n8) View all rooms\nInput:");
    menuEntry = input.next();
    System.out.println("Enter room number (0-9):" );
    roomNum = input.nextInt();
    if (roomNum < 10)
    {  
         System.out.println("Enter name for room " + roomNum +" :" ) ;
         roomName = input.next();
         hotel[roomNum] = roomName ;      
    }
} while (menuEntry.equals("1"));