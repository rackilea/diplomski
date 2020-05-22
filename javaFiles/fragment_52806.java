class Car {}
interface IService<T> {
    void create(T obj);
}

class CarService implements IService<Car> {
    public void create(Car car) {}
}