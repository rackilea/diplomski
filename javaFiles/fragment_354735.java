public class Client {

    public static void main  (String[] args) {

        URI uri = null;
        try {
            uri = new URI ("coap://192.168.200.1:5683/houses/house1/rooms/kitchen/sensors/temperature");
        } catch  (URISyntaxException e) {
            throw new RuntimeException (e.getMessage (), e);
        }

        CoapClient client       = new CoapClient (uri);

        CoapResponse response   = client.get ();

        if (response != null) {

            System.out.println (response.getCode ());
            System.out.println (response.getOptions ());
            System.out.println (response.getResponseText ());

            System.out.println ("\nADVANCED\n");
            // access advanced API with access to more details through .advanced ()
            System.out.println (Utils.prettyPrint (response));

        } else {
            System.out.println ("No response received.");
        }       
    }
}