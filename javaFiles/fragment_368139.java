@JsonCreator
public Vehicle(Map<String, String> map) {
    String color = map.get("car.color");
    String make = map.get("car.engine.make");
    Integer power = Integer.valueOf(map.get("car.engine.power"));
    Engine engine = new Engine();
    engine.setMake(make);
    engine.setPower(power);
    Car car = new Car();
    car.setColor(color);
    car.setEngine(engine);
    this.car = car;
}