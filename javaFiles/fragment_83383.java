// foo method and global variables used
private static ArrayList<Integer> foo() {
    // info class
    class Info {
        public boolean run, completed;
        public ArrayList<Integer> list;
    }
    // declare info object, list
    final Info info = new Info();
    final Object wait = new Object();
    // run a new thread
    Thread t = new Thread(
        new Runnable() {
            // run method
            @Override
            public void run() {
                // setup run
                info.run = true;
                info.completed = false;
                info.list = new ArrayList<>();
                // loop to modify list. Don't put a big piece of code that will
                // take a long time to execute in here. 
                while(info.run) {
                    // example of what you should be doing in here:
                    info.list.add(1);
                    // and if you are done modifying the list, use:
                    break;
                }
                // done modifying list
                info.completed = true;
                synchronized(wait) {
                    wait.notify();
                }
            }
        }
    );
    t.start();
    // wait for four seconds, then return list
    try {
        synchronized(wait) {
            wait.wait(4000);
        }
    } catch (InterruptedException e) { e.printStackTrace(); }
    info.run = false;
    return info.completed ? info.list : null;
}
// main method
public static void main(String[] args) {
    // get list
    ArrayList<Integer> list = foo();
    System.out.println("Done!");
}