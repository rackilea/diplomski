List<Thread> tList = new ArrayList<Thread>();

for(int i = 0; i < 50; i++) {

    final int id = i;

    tList.add(new Thread() { 
             public void run() {
                 try {
                     gate.await();
                     for (int k = 0; k < 1000; k++) {
                         System.out.println("F" + id + ":" + k);
                     }
                 }
                 catch (InterruptedException | BrokenBarrierException ex) {
                     Logger.getLogger(TestFor.class.getName()).log(Level.SEVERE, null, ex);
                 }
              }
    });
}