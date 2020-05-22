public class Main {

    public static void main(String[] args) {
        System.out.println("Normal: " + testNormal());
        System.out.println("Exception: " + testException());
    }

    public static int testNormal() {
        try {
            // no exception
            return 0;
        } catch (Exception e) {
            System.out.println("[normal] Exception caught");
        } finally {
            System.out.println("[normal] Finally");
        }
        System.out.println("[normal] Rest of code");
        return -1;
    }

    public static int testException() {
        try {
            throw new Exception();
        } catch (Exception e) {
            System.out.println("[except] Exception caught");
        } finally {
            System.out.println("[except] Finally");
        }
        System.out.println("[except] Rest of code");
        return -1;
    }

}