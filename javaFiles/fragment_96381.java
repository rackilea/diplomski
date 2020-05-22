public class ReduceCounter implements Runnable { 
        String filename;
        Map<String, Integer> words = new HashMap();
        public ReduceCounter(String filename) { this.filename = filename;}

         public void run() {
            //  store the values in the "words" map
            // here add the logic from your Reduce method, without the for loop iteration
            // also read, only the file named with the value from "filename" 

         }
        public Map<String, Integer> getWords() {return words;}
    }