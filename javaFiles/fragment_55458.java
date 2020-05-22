private Car mapCar(ResultSet rs) throws SQLException {
    Car car = null;
    while (rs.next()) {
        if (car == null) {
            Long carId = rs.getLong("ID");
            String model = rs.getString("MODEL");
            car= new Car(carId, model);
        }
        car.setEngine(mapEngine(rs));
    }
    return car;
}