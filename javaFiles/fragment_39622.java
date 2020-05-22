class CarList{
public static <U> void createCarWithEngineAndAddToCarList(U u, List<Car<U>> cars){

    /* Q: Whats is List<Car<U>>?,what is the meaning of two parameters inside the List?
     * 
     * A: "They define the List cars is only able to hold objects of the Type <Car<U>>"
     * 
     * A: At this point we know:
     * 
     *    - cars is of type List (has Methods such as 'add')
     *    - cars contains Objects of Type Car<U>
     *      => No matter what we take out of that list, it will be of type Car<U>
     *    - The type <U> is not yet known and be defined at runtime
     */

    // We create a new Car-Object 
    Car<U> car=new Car<U>();

    // We set the engine 
    car.setT(u);

    // We add the new car to the list of existing cars
    cars.add(car);
}