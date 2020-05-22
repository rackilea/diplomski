public static void main(String args[]) {
    DecimalFormat df = new DecimalFormat("###.##");
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter radius of the basketball: ");
    double radius = sc.nextDouble();
    double v = volume(radius);
    System.out.println("The volume of the basketball is " + df.format(v));
}

public static double volume(double radius) {
    return (4.0 / 3.0) * Math.PI * Math.pow(radius, 3);
}