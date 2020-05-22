long processTreeParallel(TreeCalculation tc)
{
    if (level < tc.levelParallel)
    {
        long leftResult = left.processTreeParallel(tc);
        long rightResult = right.processTreeParallel(tc);
        return value + leftResult + rightResult;
    }
    tc.incrementTasks();
    tc.cs.submit(new Callable<Long>()
    {
        @Override
        public Long call() throws Exception
        {
            return processTree();
        }
    });
    return 0;
}