import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    // notice the descriptive variable names rather than x, y and z
    double radius;
    double diameter;
    double volume;

    System.out.print("Enter the radius of the sphere:");
    radius = scanner.nextDouble();
    diameter = (radius * 2.0);
    volume = (4.0 / 3.0) * Math.PI * Math.pow(radius, 3); // instead of 4/3 in yours
    System.out.println("The volume is: " + String.format("%.1f", volume));
  }
}