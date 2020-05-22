public final class Test {

   public static void main(String[] args) {
       Customer customer = new Customer();

       Scanner sc = new Scanner(System.in);
       System.out.print("Enter Name: ");
       customer.setName(sc.nextLine());
       System.out.print("Enter Address: ");
       customer.setAddress(sc.nextLine());

       System.out.print("Enter Gender(M or F): ");
       customer.setGender(sc.nextLine());
       System.out.print("Enter Date of Birth: ");
       customer.setDob(sc.nextLine());

       writeCustomerToFile(customer,"D:/yourfilename.txt");

   }

   public static void writeCustomerToFile(Customer customer, String fileName) {

       PrintWriter writer = null;
    try {
        writer = new PrintWriter(fileName, "UTF-8");
        writer.println("name:" + customer.getName());
           writer.println("address:" + customer.getAddress());
           writer.println("gender:" + customer.getGender());
           writer.println("birth date:" + customer.getDob());

           writer.close();

       } catch (FileNotFoundException ex) {
           Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
       } catch (UnsupportedEncodingException ex) {
           Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
       } finally {
           writer.close();
       }
    }

  }