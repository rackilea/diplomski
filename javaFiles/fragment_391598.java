import java.net.HttpURLConnection;
import java.net.URL;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.annotation.adapters.XmlAdapter;

import org.example.product.Product;

public class ProductAdapter  extends XmlAdapter<String, Product>{

    private JAXBContext jaxbContext;

    public ProductAdapter() {
        try {
            jaxbContext = JAXBContext.newInstance(Product.class);
        } catch(JAXBException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String marshal(Product v) throws Exception {
        if(null == v) {
            return null;
        }
        return "http://localhost:9999/products/" + v.getId();
    }

    @Override
    public Product unmarshal(String v) throws Exception {
        if(null == v) {
            return null;
        }

        URL url = new URL(v);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("Accept", "application/xml");

        Product product = (Product) jaxbContext.createUnmarshaller().unmarshal(connection.getInputStream());
        connection.disconnect();
        return product;
    }

}