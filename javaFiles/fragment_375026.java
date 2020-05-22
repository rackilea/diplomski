package <<my_package>>;

import javax.xml.bind.annotation.*;
import java.math.BigDecimal;

@XmlType(name = "MyOtherClass", namespace = "<<my_namespace>>")
@XmlAccessorType(XmlAccessType.FIELD)
public class MyOtherClass {

    @XmlAttribute(name = "id")
    private int id;

    @XmlAttribute(name = "quantity")
    @XmlSchemaType(name = "decimal")
    private BigDecimal quantity;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }
}