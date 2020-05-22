import javax.xml.ws.Endpoint;

public class Driver {

    public static void main(String[] args) {
        String address = "http://127.0.0.1:8023/_WebServiceDemo";
        Endpoint.publish(address, new MyWebService());
        System.out.println("Listening: " + address);

    }
}