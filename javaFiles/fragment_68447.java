public static double a1 (double x, double y, double z) {
    return 0.98*Math.exp(-y - x) + 0.98*Math.exp(-y - x)*
                    y*x + 0.245*Math.exp(-y - x)*Math.pow(y,2)*
                    Math.pow(x,2) + 0.02722*
                    Math.exp(-y - x)*Math.pow(y,3)*Math.pow(x,3) +
                    0.00170*Math.exp(-y - x)*
                            Math.pow(y,4)*Math.pow(x,4) + 0.00006*
                    Math.exp(-y - x)*Math.pow(y,5)*Math.pow(x,5) +
                    1.89043*Math.pow(10,-6)*Math.exp(-y - x)*
                            Math.pow(y,6)*Math.pow(x,6) + 3.85802*Math.pow(10,-8)*
                    Math.exp(-y - x)*Math.pow(y,7)*Math.pow(x,7) +
                    6.02816*Math.pow(10,-10)*Math.exp(-y - x)*
                            Math.pow(y,8)*Math.pow(x,8) + 7.44217*Math.pow(10,-12);
}