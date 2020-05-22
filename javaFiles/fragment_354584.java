import org.springframework.core.SpringVersion;

public class VersionChecker
{
    public static void main(String [] args)
    {
        System.out.println("version: " + SpringVersion.getVersion());
    }
}