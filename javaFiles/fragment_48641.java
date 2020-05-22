import java.util.*;
import javax.xml.bind.annotation.*;

@XmlRootElement
public class Orders {

    private List<Order> orderList = new ArrayList<Order>();

    @XmlElement(name="order")
    public List<Order> getOrderList() {
        return orderList;
    }

}