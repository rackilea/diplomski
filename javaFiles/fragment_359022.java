import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;

@XmlRootElement(name = "Car")
public class Car {

    public static class Cost {

        @XmlValue
        public String value;

        @XmlAttribute
        public String currency;

        @Override
        public String toString() {
            return "Cost[value=" + value + ", currency=" + currency + "]";
        }

    }

    public static class Name {

        @XmlValue
        public String value;

        @XmlAttribute
        public String type;

        @Override
        public String toString() {
            return "Name[value=" + value + ", type=" + type + "]";
        }

    }

    private String manufacturer;
    private Name name;
    private String driverType;
    private String fuelType;

    @XmlAttribute
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    private String type;

    private Cost cost;

    @XmlElement
    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    @XmlElement
    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    @XmlElement
    public String getDriverType() {
        return driverType;
    }

    public void setDriverType(String driverType) {
        this.driverType = driverType;
    }

    @XmlElement
    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    @XmlElement
    public Cost getCost() {
        return cost;
    }

    public void setCost(Cost cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Car [name=" + name + ", fuelType=" + fuelType + ", cost=" + cost + ",driverType=" + driverType + "]";
    }

}