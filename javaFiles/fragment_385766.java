File inputFile = new File("myFile.txt");   // Your file  
File tempFile = new File("myTempFile.txt");// temp file

BufferedReader reader = new BufferedReader(new FileReader(inputFile));
BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

Scanner scanner = new Scanner(System.in);
System.out.println("Enter firstName");
String firstName = scanner.nextLine();
System.out.println("Enter lastName");
String lastName = scanner.nextLine();

String currentLine;

while((currentLine = reader.readLine()) != null) {

    if(currentLine.contains(firstName) 
         && currentLine.contains(lastName)) continue;

    writer.write(currentLine);
}

writer.close();
boolean successful = tempFile.renameTo(inputFile);
System.out.println(successful);