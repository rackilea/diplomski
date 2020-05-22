public class BoundsCheckTest {

    final static int[] array = new int[1];
    final static Random gen = new Random();

    public static void main(String[] args){

        boolean ret = false;
        int tries = 100000000;
        long timestart = System.nanoTime();

        for (int a=0; a< tries; a++) {
            ret = method1();
        }
        long timeend1 = System.nanoTime();
        System.out.println();

        for (int a=0; a< tries; a++) {
            ret = metod2();
        }
        long timeend2 = System.nanoTime();
        System.out.println();


        long t1 = timeend1-timestart;
        long t2 = timeend2-timeend1;
        System.out.println("\ntime 1=["+t1+"]\n     2=["+t2+"]"+
                 "\ndiff=["+Math.abs(t1-t2)+"] percent diff=["+(100d*t2/t1-100)+"]");

    }

    private static boolean metod2() {
        try {
            int val = array[gen.nextInt(2)];
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private static boolean method1() {
        return array.length < gen.nextInt(2);
    }

}