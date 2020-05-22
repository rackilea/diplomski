public class Carsavings3  { 

    //These are your class attributes.
    private double equalAmounts;
    private double l;
    private double amount;
    private double numberOfYears;
    private double carCost;

    public static void main(String[] args) {
       //Here you are declaring a variable to use later in the method.
       double equalAmounts, l, amount, numberOfYears, carCost;

       // Then you assign values to those variables. You must always assign the variables you declare with some value before you can use them.
       equalAmounts = 0;
       l = 0;
       amount = 0;

       //numberOfYears, carCost variables are being initialized inside your while loops, so you need not initialize them here.        

    Scanner read = new Scanner(System.in);

    do {
        //This will print out a request for the user
        System.out.println("Please input the cost of the car, a real number 0 or greater\n");
        //This will ensure the input value will remain between 0 and above
        carCost = read.nextDouble();
    } while (carCost <= 1);

    do {
        //This will print out a request for the user
        System.out.println("Please input number of years, an integer between 1 and 10\n");
        //This will ensure the input value will remain between 1 and 10
        numberOfYears = read.nextDouble();
    } while ((numberOfYears < 1) || (numberOfYears > 10));

  //This is where you create an instance of the class Carsavings3 using a parametrized constructor. You can use the variables declared and initialzed above here. But in order to use a parametrized constructor, you need to create such a constructor in your class.
  Carsavings3 Carsavings2Object = new Carsavings3 (equalAmounts, l, amount, numberOfYears, carCost);
}

 // This is how a parametrized constructor is written. A parametrized constructor is used to initialize the attributes of that class to the values passed as the parameters to this method.
private Carsavings3 (double equalAmounts, double l, double amount, double numberOfYears, double carCost) {
    this.equalAmounts = equalAmounts;
    this.l = l;
    this.amount = amount;
    this.numberOfYears = numberOfYears;
    this.carCost = carCost;

}