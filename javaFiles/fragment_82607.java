public class IncomingReader implements Runnable
{

    private final FXMLDocumentController controller ;

    public IncomingReader(FXMLDocumentController controller) {
        this.controller = controller ;
    }

    @Override
    public void run()
    {
        String message;

        try
        {
            while((message = Connection.connection.reader.readLine()) != null)
            {
                System.out.println("read" + message); //for debug, prints fine
                final String msg = message ;
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        controller.appendMessage(msg + "\n");  
                    }
                });
            }
        }
        catch(IOException e)
        {
            System.out.println("Problem!"); // TODO: Catch better.
        }
    }
}