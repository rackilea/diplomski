public static void waitingList(String name, String size){
    System.out.println("Dock 1 is full, ship will try to be added to Waiting List");
     for (int i = 0; i < waitingList.length; i++) {
         if (waitingList[i] == null) {
                //Add ship to the dock
                waitingList[i] = new Ship(name, size);
                System.out.println("Enough space. Added to waiting list.");
                return;
         } else {
                System.out.println("No space on waiting list at number "+ i +", checking next space."); //Optional
         }
     }
     // Only when no spaces available
     System.out.println("No space on waiting list, ship turned away.");
}