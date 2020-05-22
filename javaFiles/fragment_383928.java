public void Receive()
{
    receive = new Thread(new Runnable()
    {
        public void run()
        {
            receive = new Thread(new Runnable()
            {
                public void run()
                {
                    //your actual code that you wanted to run
                }
            });
        }
    });
}