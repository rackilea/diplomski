@Component 
public class Test {

    @Value("${db.password}")
    private String dbPassword;

    public void doWork() {
        System.out.println(dbPassword);
    }

}