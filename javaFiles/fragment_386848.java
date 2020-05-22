SwingUtilities.invokeLater(new Runnable()
   {
   public void run() {
     Tester t = new Tester();
     t.doSomeStuff();
   }
 });