public static void main(String[] args)
{
    Scanner inputDevice = new Scanner(System.in); //Sets up input device
    String productName; //Used for naming product
    double costMaterials, hoursWorked; //Gives variables decimal format
    System.out.println("Enter the name of the product "); //Enter product name
    productName = inputDevice.nextLine(); //Inputs product name
    System.out.println("Enter the cost of materials prior to discount "); //Enter cost of materials
    costMaterials = inputDevice.nextDouble(); //Inputs cost of materials
    System.out.println("Enter the number of hours worked "); //Enter hours worked
    hoursWorked = inputDevice.nextDouble(); //Inputs hours worked
    System.out.printf("The cost of " + productName + " is %.2f\n" , calculationMethod(costMaterials, hoursWorked));
    //Output product name and cost
}
public static double calculationMethod(double costMaterials, double hoursWorked) //Method used to calcualte price
{
    double itemDiscount = 0.75; //Gives decimal format to variable
    double payRate = 14.00; //Gives decimal format to variable
    double shipHandle = 6.00; //Gives decimal format to variable
    double firstPrice = payRate * hoursWorked; //Calculates first portion of equation
    double secondPrice = costMaterials + firstPrice; //Calculates second portion of equation
    final double thirdPrice = itemDiscount * secondPrice + shipHandle;
    //Calculates final portion of equation
    return thirdPrice; //Returns double to main() for output
}