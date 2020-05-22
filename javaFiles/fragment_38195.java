import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.*;
import java.io.StringReader;
import java.util.List;

public class Test {

    public static void main(String... args) throws JAXBException {
        String xmldata = "<request><car></car><van></van></request>";
        StringReader reader = new StringReader(xmldata);

        JAXBContext jaxbContext = JAXBContext.newInstance(Request.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

        Request request = (Request) unmarshaller.unmarshal(reader);

        for (Vehicle object : request.getVehicles()) {
            System.out.println(object.getClass());
        }
    }
}

@XmlRootElement(name = "request")
class Request {
    private List<Vehicle> vehicles;

    @XmlElements({
            @XmlElement(name = "car", type = Car.class),
            @XmlElement(name = "van", type = Van.class)
    })
    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }
}

abstract class Vehicle {
}

class Van extends Vehicle {
}

class Car extends Vehicle {
}