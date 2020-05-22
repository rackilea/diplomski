// we'll store lines of text here, a maximum of 100 at a time
ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<String>(100);

// code of thread 1 (producer)
public void run() {
   while(/* lines still exist in input file */) {
       String line = // read a line of text
       queue.put(line); // will block if 100 lines are already inserted
   }
   // insert a termination token in the queue
}

// code of thread 2 (consumer)
public void run() {
   while(true) {
       String line = queue.take(); // waits if there are no items in the queue
       if(/* line is termination token */) break;
       // write line to file
   }   
}