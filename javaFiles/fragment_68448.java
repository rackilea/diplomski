public static double f2 (double x, double y, double z) {
    double result = (0.49*Math.exp(-y - x)*Math.pow(x,2)*
            (1 - Math.pow(z,94)*(0.00666 +
                    a1()*
                    Math.exp(-y - x)*Math.pow(y,9)*Math.pow(x,9) +
                    7.44217*Math.pow(10,-14)*Math.exp(-y - x)*
                            Math.pow(y,10)*Math.pow(x,10))))/(0.01333 +
            0.98*Math.exp(-y - x)*y +
            0.49*Math.exp(-y - x)*Math.pow(y,2) +
            0.16333*Math.exp(-y - x)*Math.pow(y,3) +
            0.04083*Math.exp(-y - x)*Math.pow(y,4) +
            0.00816*Math.exp(-y - x)*Math.pow(y,5) + .....