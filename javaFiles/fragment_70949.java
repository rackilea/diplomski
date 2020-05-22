class CountPrinter extends Thread {
   String name;
   ArrayBlockingQueue<Integer> inp = new ArrayBlockingQueue<>();
   CountPrinter next;

   public void run() {
      for (;;)
         int n = inp.take();
         if (n == 11) {// only 10 numbers must be printed
            next.inp.put(11);
            return;
         }
         System.out.println(name+"->"+n);
         next.inp.put(n+1);
      }
   }
}