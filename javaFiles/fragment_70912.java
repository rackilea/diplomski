System.out.println("Enter a City : ");
Scanner input = new Scanner(System.in);
String city = input.nextLine();

//Initiates a string that contains the celsius degree Unicode So i can call it easily.
final String DEGREE  = "\u00b0";
double celsius, fahrenheit;

System.out.println("Enter your temperature in Celsius format for: " + city + " " );
celsius = input.nextInt();

System.out.println("Celsius\tFahrenheit");
System.out.println("====================");

for (int x = 0; x <= 40; x++) {
    System.out.print(celcius + x);
    System.out.print("\t\t");
    System.out.print(32 + ((celsius + x) * 9 / 5));
    System.out.println();
}