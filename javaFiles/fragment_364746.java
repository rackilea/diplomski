public class MathCode {
    public static final double x1 = 7 - 2 + Math.log10(1000)
            + Math.log(Math.pow(Math.E, 5));
    public static double x2 = 7 - 2 + Math.log10(1000)
            + Math.log(Math.pow(Math.E, 5));
    private static double x3 = 7 - 2 + Math.log10(1000)
            + Math.log(Math.pow(Math.E, 5));

    private final double x4 = 7 - 2 + Math.log10(1000)
            + Math.log(Math.pow(Math.E, 5));
    public final double x5 = 7 - 2 + Math.log10(1000)
            + Math.log(Math.pow(Math.E, 5));
    private double x6 = 7 - 2 + Math.log10(1000)
            + Math.log(Math.pow(Math.E, 5));
    public double x7 = 7 - 2 + Math.log10(1000) + Math.log(Math.pow(Math.E, 5));

    public static void main(String... args) {
        final MathCode mathCode = new MathCode();
        final double x8 = 7 - 2 + Math.log10(1000)
                + Math.log(Math.pow(Math.E, 5));
        double x9 = 7 - 2 + Math.log10(1000) + Math.log(Math.pow(Math.E, 5));
        System.out.println("x1: " + x1);
        System.out.println("x2: " + x2);
        System.out.println("x3: " + x3);
        System.out.println("x4: " + mathCode.x4);
        System.out.println("x5: " + mathCode.x5);
        System.out.println("x6: " + mathCode.x6);
        System.out.println("x7: " + mathCode.x7);
        System.out.println("x8: " + x8);
        System.out.println("x9: " + x9);
    }
}