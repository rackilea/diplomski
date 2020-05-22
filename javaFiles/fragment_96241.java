List<Future<String>> futures = threadExec.invokeAll(myClassMTCollection);
// always shutdown the pool once you are done submitting
threadExec.shutdown();
for (Future<String> future : futures) {
    // this can throw an exception that the thread threw
    String result = future.get();
}