public class Customers {
  //////// MAIN ////////
  public static void main(String[] args) {
    File file = new File("customers.txt");
    Person[] customers = readIntoArray(file, numCustomers);
    int numEntries = customers.length;
    int min = locateBirthdate(customers);
    System.out.println("Birthdays this month: " + customer[mon].getBirthdate());

  }

  public static Person[] readIntoArray(File f, int num) {
      List<Customer> customers = new ArraList<>();
      try {
        Scanner input = new Scanner(f);
        String[] strBirth = new String[num];
        while (scan.hasNextLine()) {
          customers.add(makeCustomer(scan.nextLine()));
        }
      } catch (Exception e) {
        throw new RuntimeException(e);
      }
      return customers.toArray(Person[]::new);
  }