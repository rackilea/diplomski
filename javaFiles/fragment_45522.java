public class Main {
    public static void main(String[] args) {
        class1 c1 = new class1();
        try {
            c1.createThread("t1");
        } catch (Exception e) {
            e.printStackTrace();
        }
         Thread thread = Utils.getThreadByName("t1");
         System.out.println("Thread name " + thread.getName());
    }
}