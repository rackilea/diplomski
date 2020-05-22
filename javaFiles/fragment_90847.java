executor.shutdown();  //signal that you want to shutdown executor
while(!executor.isTerminated()){
        Thread.sleep(10000);  //wait ten seconds
        System.out.println("Waiting 10 seconds");
}
// now finally traverse your value map and output your answers