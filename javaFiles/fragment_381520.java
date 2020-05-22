doSomeStuff();
Future future = executor.submit(new Callable<Integer>() {
     public Integer call() {
         //code to get Folder Object ID
         //will execute in it's own thread
     }
});
continueDoingStuff();
Integer folderId = future.get(); //Could pause here or return imidiately. Depends if the "call()" method has finished.
continueOnceFolderIdIsReturned();