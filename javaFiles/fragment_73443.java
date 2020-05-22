// Array of Runnables that we wish to process.
ParserThread[] parserThreads = ...

// Create executor service containing as many threads as there are Runnables.
// (Could potentially have less threads and let some work items be processed
// sequentially.)
ExecutorService execService = Executors.newFixedThreadPool(parserThreads.length);

// Submit each work item.  Could potentially store a reference to the result here
// to capture exceptions.
for (ParserThread runnable : parserThreads) {
  execService.submit(runnable);
}