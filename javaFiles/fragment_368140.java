Map<String, String> map = new HashMap<>();
map.put("car.color", "blue");
map.put("car.engine.make", "mitsubishi");
map.put("car.engine.power", "120");

ObjectMapper mapper = new ObjectMapper();

Vehicle vehicle = mapper.convertValue(map, Vehicle.class);