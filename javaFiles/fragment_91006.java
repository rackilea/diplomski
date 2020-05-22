// consumer
try {
   System.out.println(Thread.currentThread().getName() + "Get :"+num);
   this.wait(); // Both the threads are waiting
} 
catch (Exception e) { 

}