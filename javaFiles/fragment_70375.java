int exponent = 0;
    int sum = 0;

    while (i < number) {
        sum += exponent;
        i++;
        exponent = (int) Math.pow(2, i);
    }
    System.out.println("The result is: " + sum);