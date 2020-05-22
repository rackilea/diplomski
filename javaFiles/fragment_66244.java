import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class re{

    public static void main(String[] args){

        final String regex = "<\\d{1,3}>\\s*.*?(\\S+?)(?:\\[\\d*\\])?\\s*:\\s*(.*)";
        final String string = "<103>CP-MGMT xpand[2859]: Configuration changed from localhost by user admin by the service dbset\n\n"
             + "<31>routed[4006]: rt_instance_monitor_job: scheduled next instance monitor in 5 seconds\n\n"
             + "<134>CP_FireWall: 2Jul2017 18:52:23 accept ip address message";

        final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
        final Matcher matcher = pattern.matcher(string);

        while (matcher.find()) {
            System.out.println("Full match: " + matcher.group(0));
            for (int i = 1; i <= matcher.groupCount(); i++) {
                System.out.println("Group " + i + ": " + matcher.group(i));
            }
        }

    }
}