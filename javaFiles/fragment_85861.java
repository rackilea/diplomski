public void someMethod()
{
    new Thread(new Runnable() {
        public void run()
        {
            // do stuff
        }
    }).start();
}