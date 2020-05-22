public void yourButtonClickMethod()
{
    Runnable runner = new Runnable()
    {
        public void run() {
        //Your original code with the loop here.
        }
    };
    Thread t = new Thread(runner, "Code Executer");
    t.start();
}