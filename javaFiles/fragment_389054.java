public static LinkedList filereader (String filename) {
   LinkedList someList = new LinkedList(); // notice list initialization
   FileInputStream input = new FileInputStream(filename);
   DataInputStream in = new DataInputStream(input);
   BufferedReader reader = new BufferedReader(new InputStreamReader(in));
   String line;
   while ((line = reader.readLine()) != null) {
      if (line.equals("---")) {
         /* Do Nothing... */
      } else {
         someList.add(line);
      }
   }
   in.close();
   return(someList);
}