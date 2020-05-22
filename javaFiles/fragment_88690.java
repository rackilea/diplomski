public static void main(String[] argv)
throws Exception
{
    final Exchanger<String> exchanger = new Exchanger<String>();
    new Thread(new Runnable() 
    {
        @Override
        public void run() 
        {
            try
            {
                String s = exchanger.exchange("");
                System.out.println(s);
                exchanger.exchange("this came from subthread");
            }
            catch (InterruptedException ex)
            {
                System.out.println("interrupted while waiting for message");
            }
        }
    }).start();

    exchanger.exchange("this came from main thread");
    String s = exchanger.exchange("");
    System.out.println(s);
}