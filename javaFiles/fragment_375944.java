import javax.xml.ws.Endpoint;

public static void main(String[] args) {

      Endpoint.publish(
         "http://localhost:8080/WebServiceExample/circlefunctions",
         new CircleFunctions());

}