static WeakReference<Solution> ref;

public static void main(String[] args) {
    Solution s = new Solution();

    s = null;
    System.gc();
    try {
        Thread.sleep(1000);
    } catch (InterruptedException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }

    System.out.println(ss);
    ref = new WeakReference<Jackson>(ss);
    ss = null; // My question. What happens now?. Solution@7f5f5897 has just become unreachable. Will it be GCed without "finalize()" being called
               // on it? (looks like that..). If yes, then how can I find out when exactly has it become eligible for gc (Please don't tell me to
               // look at source code "==null" check :P)
    System.out.println(ref.get()); // (hopefully) prints object
    System.gc();
    try {
        Thread.sleep(1000);
    } catch (InterruptedException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
    System.out.println(ref.get()); // prints null
}