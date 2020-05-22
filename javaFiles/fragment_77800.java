public class Main {
    public static void main (String[]args) throws UnsupportedEncodingException, ParseException {

        List<Car> carL = new ArrayList<Car>();

        Car car1 = new Car();
        car1.setDeliveryDate(new Date());
        Gear gear1 = new Gear();
        car1.setGear(gear1);
        Tyre tyre1 = new Tyre();
        car1.setTyre(null);
        car1.setId(1);
        car1.setDeliveryDate((new SimpleDateFormat("dd-MM-yyyy")).parse("01-01-2000"));
        car1.setIsReady(0);

        Car car2 = new Car();
        car2.setDeliveryDate(new Date());
        Gear gear2 = new Gear();
        car2.setGear(gear2);
        Tyre tyre2 = new Tyre();
        car2.setTyre(tyre2);
        car2.setId(2);
        car2.setDeliveryDate((new SimpleDateFormat("dd-MM-yyyy")).parse("02-01-2000"));

        car2.setIsReady(1);

        Car car3 = new Car();
        car3.setDeliveryDate(new Date());
        Gear gear3 = new Gear();
        car3.setGear(gear3);
        Tyre tyre3 = new Tyre();
        car3.setTyre(tyre3);
        car3.setId(3);
        car3.setDeliveryDate((new SimpleDateFormat("dd-MM-yyyy")).parse("01-01-2000"));

        car3.setIsReady(1);

        carL.add(car1);
        carL.add(car2);
        carL.add(car3);
        Collections.sort(carL, new CarComparator());
        for (Car car : carL) {
            System.out.println("car: " + car.toString());
        }
    }
}