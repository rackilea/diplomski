@Override
public void run() {
    int count = 0;
    for (int i = 0; i <= 5; i++) {
        count++;
        System.out.println("counting" + count);

        // Moved block
        if (count == 3) {
            try {
                Thread t = new Thread();
                synchronized (t) {  
                    t.wait(5000);
                }
                System.out.println("thread waiting");
            } catch (InterruptedException ex) {
                Logger.getLogger(ThreadDemo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        // End of moved block
    }
}