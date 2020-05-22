// use a map or array or enum to translate transIds into methods.
final Runnable runs = Class.forName(taskClassArray[taskID]).newInstance(); 
executorService.submit(new Callable<Void>() {
    public Void call() throws Exception {
         runs.run();
    }
});