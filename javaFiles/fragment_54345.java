import org.apache.commons.exec.*;
import java.io.ByteArrayOutputStream;

public class Sample {
    private static void runCommand(String cmd) throws Exception {
        ByteArrayOutputStream stdout = new ByteArrayOutputStream();
        PumpStreamHandler psh = new PumpStreamHandler(stdout);

        // CommandLine cl = CommandLine.parse(cmd);
        CommandLine cl = new CommandLine("/bin/sh");
        cl.addArguments("-c");
        cl.addArguments("'" + cmd + "'", false);

        DefaultExecutor exec = new DefaultExecutor();
        exec.setStreamHandler(psh);
        exec.execute(cl);
        System.out.println(stdout.toString());
    }

    public static void main(String[] args) throws Exception {
        String cmd1 =  "python -c \"print(10)\"";
        String cmd2 =  "python -c \"import datetime; print(datetime.datetime.now())\"";

        runCommand(cmd1); // prints 10
        runCommand(cmd2);
    }
}