public void incomingMessageThread() throws FileNotFoundException, IOException
{
    new Thread()
    {
        public void run()
        {
            BuildData a = new BuildData();
            for(int i = 0; i<100; i++)
            {
                a.parseDataFile("_"+i+"/outgoingMessages");
            }
        }

    }.start();

}