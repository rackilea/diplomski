BlockingQueue<String> receivedQueue = new LinkedBlockingQueue<String>();
public void run()
{
    while (true)
    {
        try
        {
            receivedQueue.put(in.readUTF());
        } catch (EOFException e)
        {
            ch.getClient().disconnect();
            break;
        } catch (IOException e)
        {
            break;
        } catch (InterruptedException e)
        {
            break;
        }
    }
    theQueueProcessor.interrupt();
}