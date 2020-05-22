import java.io.File;
import javax.xml.XMLConstants;
import javax.xml.bind.*;
import javax.xml.validation.*;
import org.xml.sax.helpers.DefaultHandler;

public class Demo {

    public static void main(String[] args) throws Exception {
        JAXBContext jc = JAXBContext.newInstance(Orders.class);

        // STEP 1 - Build the Object Model
        Commodity commodity1 = new Commodity();
        commodity1.setId("1");
        Order order1 = new Order();
        order1.setCommodity(commodity1);

        Commodity commodityInvalid = new Commodity();
        commodityInvalid.setId("INVALID");
        Order order2 = new Order();
        order2.setCommodity(commodityInvalid);

        Commodity commodity3 = new Commodity();
        commodity3.setId("3");
        Order order3 = new Order();
        order3.setCommodity(commodity3);

        Orders orders = new Orders();
        orders.getOrderList().add(order1);
        orders.getOrderList().add(order2);
        orders.getOrderList().add(order3);

        // STEP 2 - Check that all the Commodities are Set
        System.out.println("\nCommodities - Before Validation");
        for(Order order : orders.getOrderList()) {
            System.out.println(order.getCommodity());
        }

        // STEP 3 - Create the XML Schema
        SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        Schema schema = sf.newSchema(new File("src/forum16953248/schema.xsd"));

        // STEP 4 - Perform Validation with the Marshal Operation
        Marshaller marshaller = jc.createMarshaller();

        // STEP 4a - Set the Schema on the Marshaller
        marshaller.setSchema(schema);

        // STEP 4b - Set the CommodityValidator as the Listener and EventHandler
        CommodityValidator commodityValidator = new CommodityValidator();
        marshaller.setListener(commodityValidator);
        marshaller.setEventHandler(commodityValidator);

        // STEP 4c - Marshal to Anything
        marshaller.marshal(orders, new DefaultHandler());

        // STEP 5 - Check that the Invalid Commodity was Removed
        System.out.println("\nCommodities - After Validation");
        for(Order order : orders.getOrderList()) {
            System.out.println(order.getCommodity());
        }
    }

}