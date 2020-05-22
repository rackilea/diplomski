interface CarQuery {
    CarQuery model(String model);
    CarQuery color(String color);
    List<CarQuery> execute(); 
}
....
List<Car> cars = carDao.getQuery().model("Jeep").color("green").execute();
....