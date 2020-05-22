import com.google.javascript.jscomp.CommandLineRunner;
import java.security.Permission;
public class MyRunner {
    public static void main(String [] args) {
        // Necessary since the closure compiler calls System.exit(...).
        System.setSecurityManager(new NoExitSecurityManager());
        for (int i=0; i<args.length; i+=2) {
            System.out.println("Compiling " + args[i] + " into " + args[i+1] + "...");
            try {
                CommandLineRunner.main(new String[] {
                    "--js=" + args[i],
                    "--js_output_file=" + args[i+1]
                });
            }
            catch (ExitException ee) {
                System.out.println("Finished with status: " + ee.getStatus());
            }
        }
    }

    private static class ExitException extends SecurityException {
        private int status;
        public ExitException(int status) { this.status = status; }
        public int getStatus() { return status; }
    }
    private static class NoExitSecurityManager extends SecurityManager {
        public void checkPermission(Permission p) { }
        public void checkPermission(Permission p, Object context) { }
        public void checkExit(int status) { throw new ExitException(status); }
    }
}