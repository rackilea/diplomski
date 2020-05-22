public class TaskSolution {

    public static void main(String[] args) {
        Vehicle car = new Car(1200, "Holden", "sedan", "Barina");
        Vehicle anotherCar = new Car(1500, "Mazda", "sedan", "323");

        System.out.println("#### A car ####");
        car.print();
        System.out.println("#### Another car ####");
        anotherCar.print();
    }

}