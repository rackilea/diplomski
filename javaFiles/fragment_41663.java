import java.util.List;
import javax.ws.rs.core.MediaType;
import org.example.Customer;
import com.sun.jersey.api.client.*;

public class JerseyClient {

    public static void main(String[] args) {
        Client client = Client.create();
        WebResource resource = client.resource("http://localhost:8080/CustomerService/rest/customers");

        // Get response as String
        String string = resource.path("1")
            .accept(MediaType.APPLICATION_XML)
                .get(String.class);
        System.out.println(string);

        // Get response as Customer
        Customer customer = resource.path("1")
            .accept(MediaType.APPLICATION_XML)
                .get(Customer.class);
        System.out.println(customer.getLastName() + ", "+ customer.getFirstName());

        // Get response as List<Customer>
        List<Customer> customers = resource.path("findCustomersByCity/Any%20Town")
            .accept(MediaType.APPLICATION_XML)
                .get(new GenericType<List<Customer>>(){});
        System.out.println(customers.size());
    }

}