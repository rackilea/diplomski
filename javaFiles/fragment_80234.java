@Component
@Profile("test") 
public class StubbyDataSource implements DataSource {
    public String getHost(){
     return "some-host";   // return mocked data
}