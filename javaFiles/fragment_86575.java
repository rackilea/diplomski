public interface ICarFactory<T extends ICar> {
    T createCar();
}

...

public <T extends ICar> T myMethod(ICarFactory<T> factory) {
    T myCar = factory.createCar();
    myCar.SetMake("Ferrari");
    return myCar;
}

...

Car car = myMethod(carFactory);