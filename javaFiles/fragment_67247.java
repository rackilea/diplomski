System.out.println("Enter Chinese: ");
final String input = new Scanner(System.in).nextLine();
final String result = new BufferedReader(new FileReader("database.txt")).lines()
  .map(line->line.split(","))
  .reduce(input, (acc, lineValues) -> acc.replace(lineValues[0], lineValues[1]+" "));
System.out.println(result);