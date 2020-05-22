import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class RunShellScript {
    public static void main(String[] args) {

        String command = "/tmp/test.sh";
        try {
            ProcessBuilder pb = new ProcessBuilder(command);

            Calendar cal = Calendar.getInstance();
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
            String time = sdf.format(cal.getTime());
            String value = "your Value";


            pb.environment().put("time", time);
            pb.environment().put("value", value);

            Process p = pb.start();
            p.waitFor();  

            BufferedReader stdInput = new BufferedReader(new InputStreamReader(
                    p.getInputStream()));

            BufferedReader stdError = new BufferedReader(new InputStreamReader(
                    p.getErrorStream()));

            // to standard output
            String s = null;
            while ((s = stdInput.readLine()) != null) {
                System.out.println(s);
            }

            // to standard error
            while ((s = stdError.readLine()) != null) {
                System.out.println(s);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}