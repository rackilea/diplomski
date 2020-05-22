class RejectionHandlerImpl implements RejectedExecutionHandler{
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        if(r instanceof MyFutureTask) {
            MyFutureTask<?> myFutureTask = (MyFutureTask)r;
            Callable<?> c=myFutureTask.theCallable;
            System.out.println(c);
        }
        else System.out.println(r);
    }
}