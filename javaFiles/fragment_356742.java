public class Mailorder {

    public static void main(String[] args) {

        //create a scanner
        Scanner input = new Scanner(System.in);

        //declare variables

        double product1 = 3.75;
        double product2 = 5.95;
        double product3 = 8.75;
        double product4 = 6.92;
        double product5 = 8.75;
        double product6 = 7.87;

        //read in product #
        System.out.print("Enter a product number: ");
        int product = input.nextInt();

        //read in quantity sold
        System.out.print("Enter quantity sold for 1 day: ");
        int quantity = input.nextInt();


        //keep reading data until the input is 0
        int sum1 = 0;
        int sum2 = 0;
        while (quantity != 0) {
            sum1 += quantity;

            double total = 0.00;
            //switch case
            switch (product)
            {
                case 1: total += product1 * quantity; break;
                case 2: total += product2 * quantity; break;
                case 3: total += product3 * quantity; break;
                case 4: total += product4 * quantity; break;
                case 5: total += product5 * quantity; break;
                case 6: total += product6 * quantity; break;
                default: System.out.println("ERROR: Invalid product number");
            }
            sum2 += total;

            //read the next data
            System.out.print("Enter a product number: ");
            product = input.nextInt();

            System.out.print("Enter quantity sold for 1 day: ");
            quantity = input.nextInt();
        }


        //print results
        System.out.println("The total number of products sold last week " + sum1);
        System.out.println("The total retail value of all products sold last week " + sum2);

    }
}