final Semaphore permits = new Semaphore(5);
 for(int i=0;i<100;i++) {
     permits.acquire();
     // add a task
 }



 // in the SwingWorker
 public String doInBackground() {
     try {
        return findTheMeaningOfLife();
     } finally {
        permits.release();
     }
 }