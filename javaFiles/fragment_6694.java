double[] prices = new double[5];

        Scanner in = new Scanner(System.in);
        System.out.println("Enter 5 prices: ");

        prices[0] = in.nextDouble();
        prices[1] = in.nextDouble();
        prices[2] = in.nextDouble();
        prices[3] = in.nextDouble();
        prices[4] = in.nextDouble();

        double total = prices[0] + prices[1] + prices[2] + prices[3] + prices[4];

        System.out.printf("the tot1al of all 5 items is:$%5.2f", total);


Output:

    Enter 5 prices: 
    .0
    .1
    .2
    .3
    .4
    the tot1al of all 5 items is:$ 1.00