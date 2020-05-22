public static void main(String[] args) {

Scanner input = new Scanner(System.in);

double startingMile;
System.out.print("Enter the starting mile: ");
startingMile = input.nextDouble();
double endingMile;
System.out.print("Enter the ending mile: ");
endingMile = input.nextDouble();
System.out.println("");

double convertedKM;
while (startingMile <= endingMile) {
    convertedKM = startingMile * 1.609;
    System.out.println("miles: " + startingMile + "," + " Kilometers: " + convertedKM);
    startingMile++;
}