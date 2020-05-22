// create a new list which can hold String objects
 List<String> names = new ArrayList<>();
 String nextName = scanner.nextLine();

 // read names until the user types stop
 while(!nextName.equals("stop")) {
     // add new name to the list. note: the list grows automatically.
     names.add(nextName);
     // read next name from user input
     nextName = scanner.nextLine();
 }

 // print out all names.
 for(String name : names) {
     System.out.println(name);
 }