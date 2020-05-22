public class Fib implements Callable<Integer> {
    int n;
    Executor exec;

    Fib(final int n, final Executor exec) {
        this.n = n;
        this.exec = exec;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer call() throws Exception {
        if (n == 0 || n == 1) {
            return n;
        }

        //Divide the problem
        final Fib n1 = new Fib(n - 1, exec);
        final Fib n2 = new Fib(n - 2, exec);

        //FutureTask only allows run to complete once
        final FutureTask<Integer> n2Task = new FutureTask<Integer>(n2);
        //Ask the Executor for help
        exec.execute(n2Task);

        //Do half the work ourselves
        final int partialResult = n1.call();

        //Do the other half of the work if the Executor hasn't
        n2Task.run();

        //Return the combined result
        return partialResult + n2Task.get();
    }

}