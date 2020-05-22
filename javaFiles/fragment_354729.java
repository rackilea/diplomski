public class TemperatureResource extends AbstractResource {

    public TemperatureResource () {
        super (ResourceSpecs.House.Sensors.Temperature);

        getAttributes ().setTitle ("Temperature resource !");
    }

    @Override
    public void handleGET (CoapExchange exchange) {
        String response = "The temperature";
        if (getWildcard () != null) {
            response += " of the " + getWildcard ().get (0) + " on the " + getWildcard ().get (1);
        }
        response += " is : 25 degree C";

        exchange.respond (response);
    }
}