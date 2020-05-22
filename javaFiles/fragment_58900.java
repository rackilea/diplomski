@Bean
public Mongo mongo() throws IOException {
    System.setProperty("DB.TRACE","true");
    return new EmbeddedMongoBuilder()
            .version("2.6.10")
            .bindIp("127.0.0.1")
            .port(allocateRandomPort())
            .build();
}