import spark.Service

public static void main(String[] args) {
    Service service1 = Service.ignite().port(8080).threadPool(20)
    Service service2 = Service.ignite().port(8081).threadPool(10)
}