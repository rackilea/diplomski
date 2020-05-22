package forum14651918;

import javax.xml.bind.annotation.*;

@XmlRootElement(name="Envelope")
public class Envelope {

    @XmlElement(name="Product")
    private Product product;

    @XmlElement(name="Instance")
    private Instance instance;

}