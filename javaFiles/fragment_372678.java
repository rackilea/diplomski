public class MySqlResource {

    //Note that the field is now static
    private static final ExecutorService executor;

    static {
        MySqlResource.executor = Executors.newFixedThreadPool(1);
    }

    //.....
    //Then the method can invoke it just as in the previous solution:
    public Response insertOrUpdate(final String user) {
        //...
        MySqlResource.executor.execute( new Runnable() {

                @Override
                public void run() {
                    //...run() code goes here
                }
            });
        //...
    }
}