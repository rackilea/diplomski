DecimalFormat formatter1 = new DecimalFormat("0");
    DecimalFormat formatter2 = new DecimalFormat("0.00");

    double[] input = {0, 1, 1.2, 1.265};
    for (int i = 0; i < input.length; i++) {
        double test = Math.round(input[i]);
        if (Math.abs(test - input[i]) < 1E-6) {
            System.out.println(formatter1.format(input[i]));
        } else {
            System.out.println(formatter2.format(input[i]));
        }
    }