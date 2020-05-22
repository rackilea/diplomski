// NameToIp2.java
import java.util.ArrayList;

public class NameToIp2 
{
    public static void main(String[] args)
    {
        // Print help message if adapter name has not been specified
        if (args.length != 1) {
            StackTraceElement[] stack = Thread.currentThread().getStackTrace();
            String prog = stack[stack.length - 1].getClassName();

            System.err.println("Usage: java " + prog + " ADAPTERNAME");
            System.err.println("Examples:");
            System.err.println("  java " + prog +" \"Local Area Connection\"");
            System.err.println("  java " + prog +" LAN");
            System.err.println("  java " + prog +" SWITCH");
            System.exit(1);
        }

        // Use NwInterface class to translate 
        NwInterface nwInterface = new NwInterface();
        ArrayList<String> ips = nwInterface.getAddresses(args[0]);
        for (String ip: ips) {
            System.out.println(ip);
        }
    }
}