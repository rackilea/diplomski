@JsonProperty("cardetail")
public Car getCarDetail(){
    Car _car = new Car();
    // (...)Clone of the original Object, ignoring the "extras"
    return _car;
}