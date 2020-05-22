List<Object> myArray = new ArrayList<Object>();
myArray.add(car);
myArray.add(banana);

for (Object o : myArray) {
    if (o instanceof Car) {
        Car c = (Car) o;
        System.out.println("Car object found.");
        // use Car object
    } else if (o instanceof Banana) {
        Banana b = (Banana) o;
        System.out.println("Banana object found.");
        // use Banana object
    } else {
        System.err.println("Unknown object found!");
    }
}