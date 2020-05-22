DecimalFormat formatter2 = new DecimalFormat("0.00");

    double[] input = {0, 1, 1.2, 1.265};
    for (int i = 0; i < input.length; i++) {
        String result = formatter2.format(input[i]);
        int pos = result.indexOf(".00");
        if (pos >= 0) {
            result = result.substring(0, pos);
        }
        System.out.println(result);
    }