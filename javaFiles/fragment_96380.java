public class WordCounter {
         public Map<String, Integer> count(String filename) throws InterruptedException {
           int chunks = splitFileInChunks(filename);
           List<ReduceCounter> counters = new ArrayList<>(); 
           List<Thread> reducerThreads = new ArrayList<>(); 

          for (int i=1; i<=chunks; i++) {
             ReduceCounter  rc = new ReduceCounter(filename + i + ".txt");
             Thread t = new Thread(rc); 
             counters.add(rc);
             reducerThreads.add(t);
             t.start();
          }
          // next wait for the threads to finish processing
          for (Thread t : reducerThreads) {
                t.join();
          }
          // now grab the results from each of them
          for (ReduceCounter cnt : counters ) {
               cnt.getWords();
               // next just merge the results here...
          }
}