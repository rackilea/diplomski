@XmlElements({
      @XmlElement(name = "car", type = Car.class),
      @XmlElement(name = "van", type = Van.class)
})
public List<Vehicle> getVehicles() {
      return vehicles;
}