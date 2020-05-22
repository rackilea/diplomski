System.out.println("Number\tSquare\tCube (n+1)/(2n-18)");
System.out.println("--------------------------------");

for (int number=1; number <= maxValue; number++) {
    double square = Math.pow(number, 2);
    double cube = Math.pow(number, 3);
    double formula = (number + 1) / (number * 2 - 18);
    System.out.println(number + "\t\t\t" + square + "\t\t\t" + cube + "\t\t\t" + formula);
}