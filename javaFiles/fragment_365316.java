package forum9812778;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.adapters.XmlAdapter;

public class CarAdapter extends XmlAdapter<CarAdapter.AdaptedCar, Car> {

    @Override
    public AdaptedCar marshal(Car car) throws Exception {
        AdaptedCar adaptedCar = new AdaptedCar();
        adaptedCar.name = car.getClass().getSimpleName();
        adaptedCar.engine = car.getEngine();
        return adaptedCar;
    }

    @Override
    public Car unmarshal(AdaptedCar adaptedCar) throws Exception {
        Car car;
        if("BMW".equals(adaptedCar.name)) {
            car = new BMW();
        } else if("Lexus".equals(adaptedCar.name)) {
            car = new Lexus();
        } else if("VW".equals(adaptedCar.name)) {
            car = new VW();
        } else if("Honda".equals(adaptedCar.name)) {
            car = new Honda();
        } else {
            return null;
        }
        car.setEngine(adaptedCar.engine);
        return car;
    }

    public static class AdaptedCar {
        @XmlAttribute
        public String name;

        @XmlAttribute
        public String engine;
    }

}