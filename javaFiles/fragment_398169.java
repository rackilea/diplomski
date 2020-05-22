@Component
public class A
{
    @Value("${username}")
    private String username;

    public void printUsername()
    {
       System.out.println(username);
    }
}