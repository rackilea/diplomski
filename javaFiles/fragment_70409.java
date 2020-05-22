@SpringBootApplication
public class SpringBootApp {
}

public class LauncherServer {
    public static void main(String[] args) {
        new SpringApplicationBuilder()
            .sources(SpringBootApp.class)
            .profiles("server")
            .run(args);
    }
}

public class ClientLauncher {
    public static void main(String[] args) {
        new SpringApplicationBuilder()
            .sources(SpringBootApp.class)
            .profiles("client")
            .web(false)
            .run(args);
    }
}