public static void main(String[] args) 
{
    ForkJoinPool pool = new ForkJoinPool();
    pool.invoke(new MyRecursiveTask());

    try
    {
        Thread.sleep(10000);
    }
    catch (InterruptedException e)
    {
        e.printStackTrace();
    }
}