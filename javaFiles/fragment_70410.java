@SpringBootApplication
@ComponentScan("...")
public class ServerSpringBootApp {
    public static void main(String[] args) {
        new SpringApplicationBuilder()
            .sources(ServerSpringBootApp.class)
            .profiles("server")
            .run(args);
    }
}

//Example of a difference between client and server
@SpringBootApplication(exclude = SecurityAutoConfiguration.class) 
@ComponentScan("...")
public class ClientSpringBootApp {
    public static void main(String[] args) {
        new SpringApplicationBuilder()
            .sources(ClientSpringBootApp.class)
            .profiles("client")
            .web(false)
            .run(args);
    }
}