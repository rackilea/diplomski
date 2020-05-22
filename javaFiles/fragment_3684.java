void mainLoop()
{
    while (true)
    {                 
        QueueingConsumer.Delivery delivery1;
        try
        {
            delivery = consumer.nextDelivery();
            //The above line waits until delivery get some value
            String result1 = new String(delivery1.getBody());
            System.out.println("Result received-"+ result1);
            processResult(result1);
        }
        catch (InterruptedException ie)
        {
            continue;
        }
    } // end while
}

void processResult(String result)
{
    // Do whatever needs to be done with 'result'
}