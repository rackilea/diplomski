Scanner lineScanner = new Scanner(fileName);
while(file.hasNextLine()){
    String line = lineScanner.nextLine();
    // parse the line
    Scanner sc = new Scanner(line);
    String firstName = sc.next();
    String lastName = sc.next();
    int year = sc.nextInt();
    int month = sc.nextInt();
    int day = sc.nextInt();
    String classYear = sc.next();
    sc.close();
    // use the variables
    // ...
}
file.close();