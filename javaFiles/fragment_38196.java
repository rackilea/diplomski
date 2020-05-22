@XmlRootElement(name = "request")
class Request {
    private Vehicle vehicles;

    @XmlElements({
            @XmlElement(name = "car", type = Car.class),
            @XmlElement(name = "van", type = Van.class)
    })
    public Vehicle getVehicles() {
        return vehicles;
    }

    public void setVehicles(Vehicle vehicles) {
        this.vehicles = vehicles;
    }
}