private boolean shutDown;

public void run()
{
    while (!shutDown)
    {
        //Do Something
        Thread.sleep(500)
    }
}
public void shutDown()
{
    shutDown = true
}