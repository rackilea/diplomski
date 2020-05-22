@Configuration
public class ApplicationContext {

    // Put the bean into the spring container
    @Bean(name = "userFile")
    public File userFile() {
        File file = new File("user.txt");
        return file;
    }
}

@Service
class UserService {

    // Ask the container to 'put' the bean here
    @Resource(name = "userFile")
    private File userFile;

}