try {
    i0 = scan.nextDouble();
    i1 = scan.nextDouble();
    i2 = scan.nextDouble();
    i3 = scan.nextDouble();
    i4 = scan.nextDouble();
    i5 = scan.nextDouble();
    i6 = scan.nextDouble();
    i7 = scan.nextDouble();
    i8 = scan.nextDouble();
    i9 = scan.nextDouble();
    double isum = i0 + i1 + i2 + i3 + i4 + i5 + i6 + i7 + i8 + i9;
    double iresult = isum / 10;

    System.out.println("The average of all the 10 numbers is " + isum);
} catch (InputMismatchException e) {
    System.out.println(e + "\nPlease, enter only numbers.");
}