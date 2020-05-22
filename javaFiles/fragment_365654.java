while (scan.hasNext()) {
    int Numbers = scan.nextInt();
    String numberStr = "" + Numbers;
    double sum = 0;

    for (int i = 0; i < Numbers; i++) {
        double d = scan.nextDouble();
        sum += d;
        numberStr += ", " + d;
    }

    double total = (((sum + 1) * sum) / (2));

    output.println("Sum From " + numberStr +" is " + total);
}