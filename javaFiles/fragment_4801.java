public static void main(String[] args)
{
    try{

    Thread t1 = new Thread()
    {
        public void run() {
            reporting("one","Starting");
        };

    };


    Thread t2 = new Thread()
    {
        public void run() {
            reporting("two","Starting");
        };

    };


    t1.start();//start the threads
    t2.start();

    t1.join();//wait for the threads to terminate
    t2.join();

    }catch(Exception e)
    {
        e.printStackTrace();

    }
}