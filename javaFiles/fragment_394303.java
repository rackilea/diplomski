@MessageEndpoint
public class MyService  
{

    @ServiceActivator( inputChannel = "input")
    public void handle( String payload )
    {
        ...
    }

};