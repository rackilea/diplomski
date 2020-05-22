double data = 55.349; // Your data value of whatever

    int decimalPlaces = 2;
    double roundBase = Math.pow(10, decimalPlaces);
    data = (double)(Math.round(data * roundBase)) / roundBase;
    System.out.println(data); // Prints "55.35"