import java.security.AccessControlContext;
import java.security.AccessController;
import java.security.CodeSource;
import java.security.Permissions;
import java.security.PrivilegedExceptionAction;
import java.security.ProtectionDomain;
import java.security.cert.Certificate;

public class QuickTest {

    public static class NoThreadsSecurityManager extends SecurityManager {

        public void checkAccess(ThreadGroup g) {
            super.checkAccess(g);
            checkPermission(new RuntimePermission("exitVM"));
        }

    }

    public static class SimpleRunnable implements PrivilegedExceptionAction<Object> {
        @Override
        public Object run() {
            try {
                Thread t = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("Thread.run()");
                    }
                });
                t.start();
                t.join();
            } catch (Exception ex) {
                System.out.println("Error running thread: " + ex);
            }
            return null;
        }
    }

    public void testModifyThreadGroup() {

        // grant no permissions
        Permissions perms = new Permissions();

        ProtectionDomain domain = new ProtectionDomain(new CodeSource(null, (Certificate[]) null), perms);
        AccessControlContext _accessControlContext = new AccessControlContext(new ProtectionDomain[] { domain });

        try {
            AccessController.doPrivileged(new SimpleRunnable(), _accessControlContext);
        } catch (Exception e) {
            System.out.println("Access Error running doPrivileged: " + e);
        }

        new SimpleRunnable().run();

    }

    public static void main(String[] args) {
        System.setSecurityManager(new NoThreadsSecurityManager());
        new QuickTest().testModifyThreadGroup();
    }

}