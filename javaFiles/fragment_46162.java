public static List<String> getCommands(String fileName) {
   if(fileName == null) return new ArrayList<String>(0);

   File file = new File(fileName);
   if(! (file.exists() && file.canRead()) {
      System.err.println("Cannot access file! Non-existent or read access restricted");
      return new ArrayList<String>(0);
   }

   List<String> commandLines = new ArrayList<String>(32);
   Scanner scanner = new Scanner(file);
   while(scanner.hasNextLine()) {
      commandLines.add(scanner.nextLine());
   }

   scanner.close();

   return commandLines;
}