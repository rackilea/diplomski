@SpringBootApplication
public class SpringBootTestApplication {
    public static void main(String[] args) {

//      SpringApplication.run(SpringBootTestApplication.class, args);

        Properties props = new Properties();
        props.put("server.ssl.key-store", "/home/ajit-soman/Desktop/test/keystore.p12");
        props.put("server.ssl.key-store-password", "123456");
        props.put("server.ssl.key-store-type", "PKCS12");
        props.put("server.ssl.key-alias", "tomcat");

        new SpringApplicationBuilder(SpringBootTestApplication.class)
            .properties(props).run(args);
    }
}