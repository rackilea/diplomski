String english = "/home/path-to-file/english";
String french = "/home/path-to-file/french";
BufferedReader enBr = new BufferedReader(new FileReader(english));
BufferedReader frBr = new BufferedReader(new FileReader(french));

while (true) {
    String partOne = enBr.readLine();
    String partTwo = frBr.readLine();

    if (partOne == null || partTwo == null)
        break;

    System.out.println(partOne + "\t" + partTwo);
}