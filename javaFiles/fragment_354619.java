public static void main(String[] args) {
    igniteFirstSpark();
    igniteSecondSpark();
}

static void igniteSecondSpark() {
    Service http = ignite();

    http.get("/basicHello", (q, a) -> "Hello from port 4567!");
}

static void igniteFirstSpark() {
    Service http = ignite()
                      .port(8080)
                      .threadPool(20);

    http.get("/configuredHello", (q, a) -> "Hello from port 8080!");
}