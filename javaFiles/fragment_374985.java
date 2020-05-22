File file = new File("file.txt");
Scanner scanner = new Scanner(file).useDelimiter("\n");
String line = scanner.next();
//Store in the list
//Append the new lines
//Write the whole list into a new file