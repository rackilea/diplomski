public class SurdsMain {
    public static void main(String[] args) {
        final double SQRT2 = Math.sqrt(2);
        final double SQRT3 = Math.sqrt(3);

        for(int a = -100; a <= 100; a++) {
            for(int b = -100; b <= 100; b++) {
                for(int c = -100; c <= 100; c++) {
                    if(Double.compare(a * SQRT2 - b, c * SQRT3) == 0) {
                        System.out.println("a = " + a + "; b = " + b + "; c = " + c);
                    }
                }
            }
        }
    }
}