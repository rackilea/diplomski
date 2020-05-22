@JsonTypeInfo(
  use = JsonTypeInfo.Id.NAME, 
  include = JsonTypeInfo.As.PROPERTY, 
  property = "type")
@JsonSubTypes({ 
  @Type(value = Car.class, name = "car"), 
  @Type(value = Truck.class, name = "truck") 
}) // magic happens here, when we give type information using per-class annotations, this will be used by jackson to convert the json to appropriate java objects.
public abstract class Vehicle {
    private String make;
    private String model;

    protected Vehicle(String make, String model) {
        this.make = make;
        this.model = model;
    }

    // no-arg constructor, getters and setters
}