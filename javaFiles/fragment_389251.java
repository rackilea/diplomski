public class CarConverter implements Serializable {
transient Gson gson;

private Gson getGson() {
    if (gson == null) {
        gson = new Gson();
    }
    return gson;
}

public JavaRDD<Car> convert(JavaRDD<String> rdd) {
    return rdd.map(a -> getGson().fromJson(a, Car.class));
}
}