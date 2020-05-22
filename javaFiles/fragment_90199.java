int testM() {
    try {
       final TestAutoCloseable closable = new TestAutoCloseable();
       Throwable #primaryExc = null;
       try {
           System.out.println("Do first return");
           return 1;
       } catch (Throwable #t) {
           #primaryExc = #t;
           throw #t;
       } finally {
           if (closable != null) {
              if (#primaryExc != null) {
                 try {
                    closable.close();
                 } catch (Throwable #suppressedExc) {
                    #primaryExc.addSuppressed(#suppressedExc);
                 }
              } else {
                 closable.close();
              }
          }
       }
    } catch (IOException e) {
       System.out.println("handled");
    }
    System.out.println("Do something, that shouldn't do if first return have happened");
    return 2;
}