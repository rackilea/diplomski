@Remote
public interface SinaRemote {
    String getHello();
}

@Stateless
public class SinaBean implements SinaRemote {

    public String getHello() {
        return "hello";
    }
}