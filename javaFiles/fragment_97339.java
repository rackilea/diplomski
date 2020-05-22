final Scanner scanner = new Scanner(file);
while (scanner.hasNextLine()) {
   final String lineFromFile = scanner.nextLine();
   if(lineFromFile.contains(name)) { 
       // a match!
       System.out.println("I found " +name+ " in file " +file.getName());
       break;
   }
}