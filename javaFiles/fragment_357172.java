File myFile = new File("path-to-my-file");
Scanner scn = new Scanner(myFile);

while (scn.hasNextLine()) {
    scn.useDelimiter("\\]");
    String coord = scn.next() + "]";
    scn.useDelimiter("\\p{javaWhitespace}+");
    scn.next();  // Throw away ] delim
    scn.next();  // Throw away junk between coord and date
    String date = scn.next();
    String time = scn.next();
    String line = scn.nextLine();
    System.out.println("Coodinates: " + coord);
    System.out.println("Date: " + date);
    System.out.println("Time: " + time);
    System.out.println("Line: " + line);
}