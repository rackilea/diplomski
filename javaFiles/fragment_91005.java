// producer
notify();
try {
   System.out.println(Thread.currentThread().getName() + " Put :"+num);
   this.wait(); // lock released
} 
catch (Exception e) {

}