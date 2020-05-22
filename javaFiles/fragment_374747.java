public class StackEater{
    public static void main(String[] args) throws Exception {

    Thread t = new Thread(new Runnable() {
                   public void run() {
                      printLevel(1);
                   }});
    t.start();
    t.join()
    }

    public static void printLevel(long n) {

        System.out.println(n);
        printLevel(n+1);

    }
}