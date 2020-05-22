private double multiplication(double d1, double d2) {

        double divDiff1 = 1, divDiff2 = 1;

        while (d1 != Math.floor(d1)) {
            d1 = Double.valueOf(String.format("%.6f", d1 / 0.1));
            divDiff1 = divDiff1 / 0.1;
        }
        while (d2 != Math.floor(d2)) {
            d2 = Double.valueOf(String.format("%.6f", d2 / 0.1));
            divDiff2 = divDiff2 /0.1;
        }

        double mul = 0;
        for (int i = 1; i <= d1; i++)
            mul = mul + d2;

        return mul / divDiff2 / divDiff1;
    }