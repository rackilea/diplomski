public class ReadCarFile {

    public static final Gson gson = new GsonBuilder().registerTypeAdapter(Car.class, new CarTypeAdapter()).create();

    public static void main(String[] args) {
        String input = "{\"car\":{\"name\":\"Toyota\",\"vin\":637834623,\"location\":”SomePlace\"}}";

        Car result = gson.fromJson(input, Car.class);
    }

    static class CarTypeAdapter implements JsonDeserializer<Car> {

        @Override
        public Car deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
            JsonObject carObject = jsonElement.getAsJsonObject().get("car").getAsJsonObject();

            Car car = new Car();
            car.name = carObject.get("name").getAsString();
            car.vin = carObject.get("vin").getAsInt();
            car.location = carObject.get("location").getAsString();
            return car;
        }
    }

    static class Car {

        @SerializedName("name")
        public String name;

        @SerializedName("vin")
        public int vin;

        @SerializedName("location")
        public String location;

    }
}