public class Main {

    public static void main(String[] args) {
        List<Vehicle> list=new ArrayList<>();

        list.add(new Car());
        list.add(new Bike());
    }
}

class Vehicle{}
class Car extends Vehicle{}
class Bike extends Vehicle{}