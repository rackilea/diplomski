public class CallableDemo implements Callable<Long>
{
 private Long count = 0L;

public CallableDemo(Long i)
{
    this.count = i;
}

public Long call() throws InterruptedException
{
    Long i;
    for( i = this.count; i < 100L; i++)
    {
        try { Thread.sleep(100); }
            catch (InterruptedException e) {
                System.out.println("Interruped " + Thread.currentThread().getName());
                //Thread.currentThread().interrupt();
            return i;
        }
        //System.out.println(Thread.currentThread().getName() + " - " + i);
    }
    System.out.println("Finished " + Thread.currentThread().getName());
    return i;
}
}