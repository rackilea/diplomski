int number = input.nextInt();

    int t1 = 1 + (number-100) / 100;
    int t2 = (1 + (number-10) / 10) % 10; \\By NVioli
    int t3 = number % 10;

    int  product = t1 * t2 * t3;

    System.out.println(product);