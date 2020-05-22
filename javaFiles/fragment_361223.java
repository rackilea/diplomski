public class Stats {
     // the currently available stat instance
     public static AtomicReference<Stats> CURRENT_STATS = 
         new AtomicReference<>(new Stats());

     private final int whatever1;
     private final int whatever2;

     private Stats() {
         this(0, 0);
     }

     public Stats(int whatever1, int whatever2) {
         this.whatever1 = whatever1;
         ...
     }

     public int getWhatever1() {
         return whatever1;
     }

     public int getWhatever2() {
         return whatever2;
     }

}