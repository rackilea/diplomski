void printSum(Server server) {
     try {
         int sum = computeSum(server);
         System.out.println("Sum: " + sum);
     } catch (InterruptedException e) {
         Thread.currentThread().interrupt();  // set interrupt flag
         System.out.println("Failed to compute sum");
     }
}