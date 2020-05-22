class Librarian {
    Semaphore sme = new Semaphore(NUMBER_OF_SMES);

    void requestSme() throws InterruptedException {
        sme.acquire();
    }

    void releaseSme() {
        sme.release();
    }
}

 class Student {
     Librarian librarian;

     public void run() {

         libarian.requestSme();
         try {
             // Do something
         finally {
             librarian.releaseSme();
         }
     }
}