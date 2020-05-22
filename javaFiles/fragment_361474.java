@Override
public void run() {
int count = 0;
    for (int i = 0; i < 1000; i++) {
        if (i % 2 == 0) {
            try {
                System.out.println(i);
                Thread.sleep(500);
                count+=1

            } catch (InterruptedException ex) {
                Logger.getLogger(ThreadNumeros.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    System.out.println("thread has been suspended for: "+count);

}