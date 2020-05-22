public class WordCounter {
       private static ExecutorService threadPool = Executors.newFixedThreadPool(5);  // 5 represents the number of concurrent threads.

       public Map<String, Integer> count(String filename) {
          int chunks = splitFileInChunks(filename);
          List<Future<Report>> reports = new ArrayList<Future<Report>>();

          for (int i=1; i<=chunks; i++) {
             Callable<Report> callable = new ReduceCallable(filename + i + ".txt");
             Future<Report> future = threadPool.submit(callable);
             reports.add(future);
          }

          Map<String, Integer> finalMap = new HashMap<>();
          for (Future<Report> future : reports) {
              Map<String, Integer>  map = future.get().getWords();
              for (Map.Entry<String, Integer> entry : map.entrySet()) {
                  int oldCnt = finalMap.get(entry.getKey()) != null ? finalMap.get(entry.getKey()) : 0;
                  finalMap.put(entry.getKey(), entry.getValue() + oldCnt);
              }
          }
          //  return a map with the key being the word and the value the counter for that word
          return finalMap; 
       }

       // this method doesn't need to be run on the separate thread
       private int splitFileInChunks(String filename) throws IOException { .... }
    }

    public class Report {
           Map<String, Integer> words = new HashMap<>();
           // ... getter, setter, constructor etc
    }

    public class ReduceCounter implements Callable<Report> { 
        String filename;
        public ReduceCounter(String filename) { this.filename = filename;}

         public Report call() {
            //  store the values in a Map<String, Integer> since it's easier that way
            Map<String, Integer>  myWordsMap = new HashMap<String, Integer>;
            // here add the logic from your Reduce method, without the for loop iteration
            // you should add logic to read only the file named with the value from "filename" 

            return new Report(myWordsMap);
         }
    }