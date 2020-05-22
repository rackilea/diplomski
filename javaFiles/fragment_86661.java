import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main{
    public static void main(String[] args) {

        String regex = "(\\/usr\\/lib\\/ocf\\/resource\\.d\\/[a-zA-Z_]*(\\.sh[\\s|]?)?)";
        String string = "-rwxr-xr-x. 1 root root 971 Sep 22 13:15 /usr/lib/ocf/resource.d/cloud_init_ocf.sh/n-rwxr-xr-x. 1 root root 662 Aug 28 11:25 /usr/lib/ocf/resource.d/credentialmanagercliRestartVM.sh/n-rwxr-xr-x. 1 root root 843 Sep 28 11:13 /usr/lib/ocf/resource.d/jboss_healthcheck.sh";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(string);
        int i =1;
        while (matcher.find()) {
                System.out.println("Group " + i++ + ": " + matcher.group(0));
        }
    }
}