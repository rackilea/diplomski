while (true) {
    synchronized(queue) {
         while (queue.isEmpty()) {
             try {
                 queue.wait();
             } catch (InterruptedException ignored) {
                 //don't ignore me please
                 //you probably should exit the loop and return here...
             }
         }
         r = queue.removeFirst(); //Why use a cast? Use generics instead.
     }
 }