@Component
@Profile("Prod") 
public class DevDataSource implements DataSource {
    public String getHost(){
     // return actual value
}