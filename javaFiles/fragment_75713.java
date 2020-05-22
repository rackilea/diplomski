@SpringBootApplication 
    public class DemoApplication {

        public static void main(String[] args) {        
           SpringApplication.run(DemoApplication.class, args);  
        }

        @StoreRestResource(path="test-videos")  
        public interface VideoStore extends Store<String> {} 
    }