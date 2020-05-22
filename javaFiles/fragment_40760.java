public class MyService {   

    private final String apiPort;

    public MyService (@Value("${server.port}") String apiPort){
        this.apiPort = apiPort;
    }
}