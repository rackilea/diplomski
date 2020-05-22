final Scanner in = new Scanner(System.in);
System.out.println("Enter Chinese: ");
String input = in.nextLine();
BufferedReader br = new BufferedReader(new FileReader("database.txt"));
for (String sCurrentLine; (sCurrentLine = br.readLine()) != null;) {
  final String[] lineValues = sCurrentLine.split(",");
  input = input.replace(lineValues[0], lineValues[1]+" ");
}
System.out.println(input);