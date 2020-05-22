public static void main(String[] args) throws InterruptedException {
    AsyncExecutor asyncExecutor = new AsyncExecutor(1);
    for (int i = 0; i < 100; i++) {
        asyncExecutor.submit(new Foo(i));
    }
    Thread.sleep(10000);
}

static class Foo implements AsyncTask<Object>
{

    private int i;

    public Foo(int i) {
        this.i = i;
    }

    @Override
    public Object call() throws Exception
    {
        try{
            System.out.println("Start" + i + "/" + Thread.currentThread().getName());

            if((this.i % 9) == 0){
                throw new Exception("Ugly.");
            }

            System.out.println("Stop " + i + "/" + Thread.currentThread().getName());

        } catch (Throwable t){
            t.printStackTrace();
        }
        return null;
    }
}