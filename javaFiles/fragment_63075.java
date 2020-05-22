@SpringBootApplication
public class SpringDocBotApplication {

    public static void main(String[] args) {
        File file = new File("EXPECTED PATH"); 

        try{
            if(!file.exists()){
                // create propeties file add properties
            }
        } catch (IOException e) {
         //HANDLE EXCEPTION
        }
        SpringApplication.run(SpringDocBotApplication.class, args);
    }
}