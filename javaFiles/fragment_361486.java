private static void userCircle() {

    double radius = 0;
    double area = 0;
    double perimeter = 0;
    do {
        String enteredRadius = JOptionPane.showInputDialog(null,
                "Enter a number greater than 0 for the radius of the circle. ", "1");
        radius = Double.parseDouble(enteredRadius);
        area = 3.14 * radius * radius; //Change for your Circle.getArea() method
        perimeter = 3.14 * 2 * radius; //Change for your Circle.getPerimeter() method
    } while (radius < 10 || radius > 30);
    JOptionPane.showMessageDialog(null,
            "A circle with the radius of " + unitTest(radius) + " has\n"
            + "an area of " + unitTest(area) + ",\n"
            + "and a perimeter = " + unitTest(perimeter) + ".");
}