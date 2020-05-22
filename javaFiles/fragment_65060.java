public class GenericCheck {

    static void insertCar(List<? super Car> c, Car x) {

        c.add(x);
    }

    public static void main(String[] args) {

        List<Car> c = new ArrayList<>();
        Nissan n = new Nissan();
        insertCar(c, n);
    }
}

class Car {}

class Nissan extends Car {}