Task<String> myTask = new my_task(); // Please use standard naming conventions, i.e. new MyTask();
pool.submit(myTask);

try {
    // sleep is unnecessary, get() will block until ready anyway
    System.out.println(myTask.get());
} catch (InterruptedException | ExecutionException ex) {
    Logger.getLogger(Return_test.class.getName()).log(Level.SEVERE, null, ex);
}