System.out.println("Program has Ended");
try {
   Thread.sleep(5000); //5000 milliseconds = 5 seconds.
} catch (InterruptedException e) {
   e.printStackTrace();
}
System.exit(0);