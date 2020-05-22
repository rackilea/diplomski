public static void doOption1(Voter voter){
      System.out.println("Please, enter the below details to register for voting system.");
      System.out.println("Full name");
      String name = keyboard.nextLine();
      voter.add(new Voter(name)); // you could validate name before constructing the object if you see fit.
}