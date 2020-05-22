public class InstanceOfTest {
    public static void main(String[] args) {
        Object nullObject = null;

        long start = System.nanoTime();         
        for(int i = Integer.MAX_VALUE; i > 0; i--) {
            if (nullObject instanceof InstanceOfTest) {}
        }
        long timeused = System.nanoTime() - start;  

        long start2 = System.nanoTime();
        for(int i = Integer.MAX_VALUE; i > 0; i--) {
            if (nullObject == null) {}
        }
        long timeused2 = System.nanoTime() - start2;

        System.out.println("instanceof");
        System.out.println(timeused);       
        System.out.println("nullcheck");
        System.out.println(timeused2);
    }
}