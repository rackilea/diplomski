doInTransaction(session -> {
    Car car = new Car();
    car.transmission = "Auto";

    Car car1 = new Car();
    car1.transmission = "Manual";

    Factory factory = new Factory();
    session.persist(factory);
    session.persist(car);
    session.persist(car1);

    CarFactory carFactory = new CarFactory();
    carFactory.setCar(car);
    carFactory.setFactory(factory);

    CarFactory carFactory1 = new CarFactory();
    carFactory1.setCar(car1);
    carFactory1.setFactory(factory);

    session.persist(carFactory);
    session.persist(carFactory1);
});