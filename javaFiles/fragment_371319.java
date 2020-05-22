public static void main(String[] args) {

    List<PolynomialMember> polynom = new ArrayList<PolynomialMember>();
    polynom.add(new PolynomialMember("-5", 3));
    polynom.add(new PolynomialMember("7", 1));
    polynom.add(new PolynomialMember("4", 0));
    polynom.add(new PolynomialMember("8", 2));

    for(PolynomialMember pm : polynom) {
        System.out.print(pm + " ");
        // prints: -5x^3 +7x^1 +4x^0 +8x^2 
    }
    System.out.println();
    Collections.sort(polynom); //this is where the magic happens.
    for(PolynomialMember pm : polynom) {
        System.out.print(pm + " ");
        // prints: +4x^0 +7x^1 +8x^2 -5x^3 
    }
}