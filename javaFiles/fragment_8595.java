if (h == 0) {
    h = Math.sqrt((b * b) + (hi * hi));

    System.out.println("The hypotenuse side is:" + h);

} else if (hi == 0) {
    hi = Math.sqrt((h * h) - (b * b));

    System.out.println("The height is: " + hi);

} else if (b == 0) {
    b = Math.sqrt((h * h) - (hi * hi));

    System.out.println("The height is: " + b);
}