static void cosSin(double angle) {
    double cos = Math.cos(angle);
    double sin = Math.sin(angle);
    System.out.printf("%.4f : %.1f %.1f \n", angle, cos, sin);
}

public static void main(String[] args) {
    System.out.println("Radians: (cos, sin)");
    double angle = 0.0;
    double piDivideTwo = Math.PI / 2.0;
    double pi = Math.PI;
    cosSin(angle);        // 0,0000 :  1,0 0,0
    cosSin(piDivideTwo);  // 1,5708 :  0,0 1,0
    cosSin(pi);           // 3,1416 : -1,0 0,0
}