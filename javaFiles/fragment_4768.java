Callable<ResultOfMyTask> callable = new Callable<ResultOfMyTask>() {
    public ResultOfMyTask call() {
        // here goes your task code which is to be invoked by thread pool 
    }
};

final ServletContext servletContext = ...;
final ExecutorService threadPool = (ExecutorService) servletContext.getAttribute("threadPoolAlias");
final Future<ResultOfMyTask> myTask = threadPool.submit(callable);;