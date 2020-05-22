class Librarian {
    BlockingQueue<SubjectMatterExpert> q = 
        new ArrayBlockingQueue<SubjectMatterExpert>(NUMBER_OF_SMES);

    public Librarian() {
        for (int i = 0; i < NUMBER_OF_SMES; i++)
            q.put(new SubjectMatterExpert(String.valueOf(i));
    } 

    SubjectMatterExport requestSme() throws InterruptedException {
        q.take();
    }

    void releaseSme(SubjectMatterExpert toRelease) {
        q.put(toRelease);
    }
}

 class Student {
     Librarian librarian;

     public void run() {

         SubjectMatterExpert sme = libarian.requestSme();
         try {
             System.out.println("Student: " + this + ", SME: " sme);
         finally {
             if (sme != null)
                 librarian.releaseSme(sme);
         }
     }
}