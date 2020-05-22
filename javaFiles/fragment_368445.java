import javax.management.*;
import java.lang.management.*;
import java.util.concurrent.atomic.AtomicBoolean;

public class Server implements ServerMBean {
    AtomicBoolean running;

    public void register() throws Exception {
        MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
        ObjectName serverBeanName = null;
        serverBeanName = new ObjectName("ServerBean:name=TestBean");
        mbs.registerMBean(this, serverBeanName);
    }

    public void stop() {
        running.set(false);
    }

    public void runServer() throws Exception {
        int cnt = 0;
        running = new AtomicBoolean(true);
        while(running.get()) {
            Thread.sleep(1000);
            System.out.println("tic tic " + cnt++);
        }
    }

    public static void main(String args[]) throws Exception {
        Server bean = new Server();
        bean.register();
        bean.runServer();
    }
}