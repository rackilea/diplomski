public class GrandChild {

    public static void main(String[] args) throws Exception {
        System.out.println("GrandChild sleeping...");
        Thread.sleep(5_000L); // 5 seconds
        System.out.println("GrandChild exiting...");
    }

}