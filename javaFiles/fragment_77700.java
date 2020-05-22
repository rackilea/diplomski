public class ProductTesterPart1{
public static void main(String[] args) {
     Scanner userInput = new Scanner(System.in);
     System.out.println("Please enter the product number, name, stock, and price in that order.");

     List<ProductPart1> products = new ArrayList<ProductPart1>();
     String line = userInput.nextLine();
     while (!line.equals("quit")) {
         if (line == null || line.trim().isEmpty()) {
             products.add(new ProductPart1());
         }
         else {
             try {
                 Scanner s = new Scanner(line);
                 int number = s.nextInt();
                 String name = s.next();
                 int stock = s.nextInt();
                 double price = s.nextDouble();
                 products.add(new ProductPart1(number, name, stock, price));
             } catch (NoSuchElementException e) {
                 System.out.print("Error: " + e.getMessage());
             }
        }
        if(userInput.hasNext()){
            line = userInput.nextLine();
        } else {
            break;
        }
     }

     for (ProductPart1 p : products) {
          System.out.println(p.toString());
     }
  }
}