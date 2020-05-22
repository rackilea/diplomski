File customerList = new File("./src/Customers.txt");
Scanner fileScanner = new Scanner(customerList);

List<String> customerNames = new ArrayList<String>();
while(fileScanner.hasNextLine())
{
    String line = fileScanner.nextLine();
    Scanner lineScanner = new Scanner(line);
    lineScanner.useDelimiter(",");
    lineScanner.next(); // Discard number
    customerNames.add(lineScanner.next());
}

for(String name : customerNames)
{
    System.out.println(name);
}