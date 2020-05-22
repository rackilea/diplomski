import java.lang.*;
import java.io.*;
import java.util.*;
public class test {
    public static void main (String[] args) throws IOException, InterruptedException {
        if (args.length == 0) {
            ArrayList<String> childargs = new ArrayList<String>();
            childargs.add("java");
            childargs.add("test");
            String quotedArg = "--p='sprintf(\"%8d %13s\")'";
            //
            // HERE'S THE KEY CODE FRAGMENT
            //
            if (isWin()) {
                quotedArg = quotedArg.replace("\"", "\\\"");
            }
            childargs.add(quotedArg);
            for (String s : childargs)
                System.out.println(String.format("Parent: arg=<%s>", s));
            ProcessBuilder pb = new ProcessBuilder(childargs);
            pb.inheritIO();
            Process p = pb.start();
            int rc = p.waitFor();
            System.out.println("Parent: child rc=" + rc);
        } else {
            for (int i=0; i<args.length; i++)
                System.out.println(String.format("Child:  arg=<%s>", args[i]));
            System.exit(3);
        }
    }

    static boolean isWin() {
        return System.getProperty("os.name").toLowerCase().indexOf("win") >= 0;
    }
}