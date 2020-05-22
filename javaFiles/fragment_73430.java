public class Hotel {

/**
 * @param args the command line arguments
 */
private static String[] hotel= new String[11];
public static void main(String[] args) {
    String command;
    Scanner input = new Scanner(System.in);
    String roomName;
    int roomNum = 0;
    initialise();   

    while ( roomNum  < 11 )

    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter command : ");
        command = input.next();

        if (command.charAt(0) == 'a') {
            addcustomer();
        }

        if (command.charAt(0) == 'v') {
            viewoccupants();
        }

        if (command.charAt(0) == 'e') {
            emptyrooms();

        }

        if (command.charAt(0) == 'd') {
            deleteroom();  
        }    

        if (command.charAt(0) == 'f') {
            findroom();  
        }    
    }
}

 private static void initialise( ) {
     for (int x = 0; x < 11; x++ ) hotel[x] = "e";
     System.out.println( "initilise ");
  }

private static void viewoccupants() {
         for (int x = 0; x < 11; x++ )
          {
           System.out.println("room " + x + " occupied by " + hotel[x]);
         }
}

private static void addcustomer() {
    String roomName;
    int roomNum;
    Scanner input = new Scanner(System.in);
    System.out.println("Enter room number (0-10) or 11 to stop:" ) ;
    roomNum = input.nextInt();
    if (roomNum<11) {
        System.out.println("Enter name for room " + roomNum +" :" ) ;
        roomName = input.next();
        hotel[roomNum] = roomName ;   
    }
    else {
        System.exit(0);
    }
}

private static void emptyrooms() {
    for (int x = 0; x < 11; x++ )
          {
           if (hotel[x].equals("e"))System.out.println("room " + x + " is empty");
         }
}

private static void deleteroom() {
    String x = "e";
    int roomNum;
    Scanner input = new Scanner(System.in);
    System.out.println("Enter room to be vacated: " );
    roomNum = input.nextInt();
    if (roomNum<11) {
        hotel[roomNum] = x;   
    }
    else {
        System.exit(0);
    }
}

private static void findroom() {
    String roomName;
    Scanner input = new Scanner(System.in);
    System.out.println("Enter name: " ) ;
    roomName = input.next();


    for(int i = 0; i < hotel.length; i++){
        if(hotel[i].equals(roomName)){
            System.out.println(roomName + " is located in room " + i);
        }
     }
   }