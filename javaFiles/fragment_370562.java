ObjectMapper objectMapper = new ObjectMapper();

Car car = new Car();
car.car_comp = "BMW";
car.car_type = Arrays.asList("modelA", "modelB", "modelC");
car.car_price = "$1500";
car.car_comp_value = "$65.4M";

String json = objectMapper.writeValueAsString(car);