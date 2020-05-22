class K{

   static int instancesCount; 
   // Or "static AtomicInteger instancesCount;" if you do multithreading

   final int nth_instance; // this is your non-static field


   K(){
     instancesCount++;
     this.nth_instance = instancesCount;

     // In case of multithreading, replace both lines by
     // this.nth_instance = instancesCount.incrementAndGet();
   }                 

   public static void main(String[] args){
     K k1 = new K(); //k1.nth_instance == 1;
     K k2 = new K(); //k1.nth_instance == 2;
   }
 }