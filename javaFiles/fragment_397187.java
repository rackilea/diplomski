import java.util.Scanner;


public class Driver {

    public static void main(String[] args) {
        // Create a new scanner to help you get information from the input
        // stream.
        Scanner scanner = new Scanner(System.in);

        // Prompt and get user input for all 12 digits of UPC code
        System.out.println("Enter all twelve digits of your UPC code.");
        System.out.println("Please enter in this format: * ***** ***** *.");

        // get the next input
        String input = scanner.nextLine();

        Upc userUpc = new Upc(input);

        // Output data
        System.out.println("The item's UPC value is: " + userUpc.toString());
        System.out.println();

        System.out.println("Product Type: " + userUpc.getItemType());
        System.out.println("Manufacturer: " + userUpc.getManufacturer());
        System.out.println("Product: " + userUpc.getProduct());
        System.out.println();

        System.out.println("Calculated Check Digit: " //+ userUPC.getCalculatedCheck()
                );
        System.out.println("UPC Check Digit: " + userUpc.getCheckDigit());

        scanner.close();
    }

}

class Upc {

    // Instance variables
    private int itemType; // digit 1

    private int manufacturer; // digits 2,3,4,5,6
    private int product; // digits 7,8,9,10,11

    private int checkDigit; // digit 12

    // constructor that accepts String
    public Upc(String upcString) {
        //Scanner for the given input that will help us get data from it
        Scanner scanner = new Scanner(upcString);

        itemType = scanner.nextInt(); //get item type
        manufacturer = scanner.nextInt(); //get manufactor
        product = scanner.nextInt(); //get product
        checkDigit = scanner.nextInt(); //get chackDigit

        setVariables(itemType, manufacturer, product, checkDigit);

        scanner.close();
    }

    public Upc(int item, int man, int prod, int check)
    {
        setVariables(item, man, prod, check);
    }

    private void setVariables(int item, int man, int prod, int check)
    {
        this.itemType = item;
        this.manufacturer = man;
        this.product = prod;
        this.checkDigit = check;
    }

    // Return the UPC code with "-" inserted between the different secions of
    // the barcode
    public String toString() {
        return itemType + "-" + manufacturer + "-" + product + "-" + checkDigit;
    }

    // Return the UPC's item type (First digit)
    public int getItemType() {
        return itemType;
    }

    // Return the manufacturer code (Digits 2-6)
    public int getManufacturer() {
        return manufacturer;
    }

    // Return the product code (Digits 7-11)
    public int getProduct() {
        return product;
    }

    // Return the check digit (Digit 12)
    public int getCheckDigit() {
        return checkDigit;
    }

    // Calculate and return the calculated check digit (Equation)
    // public int getCalculatedCheckDigit() {
    //
    // }

}