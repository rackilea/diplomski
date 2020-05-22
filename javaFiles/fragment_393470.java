public void run() {

   while (!Thread.isInterrupted()) {
      doSomethinginTheLoop1();
      blah...blah...blah
      // if the loop is very long you might want to check isInterrupted 
      // multiple times for quicker termination response
      doSomethingInTheLoop2();
   }

   // now, here's a decision of what you do
   // do you throw an InterruptedException or trust others to check interrupted flag.
   // read Java COncurrency in Practice or similar...
}