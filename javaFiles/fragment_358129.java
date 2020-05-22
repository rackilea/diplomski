private static void processTask() {
           try {
             //task business logic
               int x=2/0;
           } catch(Exception e) {
                 System.out.println(e.getMessage());
                //I want to be aware of this exception also
                  executor.shutdown();
           }
        }