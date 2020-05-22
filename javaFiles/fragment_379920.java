@Endpoint
public class MyFlightEndpoint{
    @Action("http://www5v80.elsyarres.net/searchFlights")
    public SearchFlights request() {
        ...
    }
}