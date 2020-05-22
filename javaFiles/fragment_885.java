import com.sun.management.OperatingSystemMXBean;
import java.lang.management.ManagementFactory;

public class OSMX {
    public static void main(String[] args) {
        OperatingSystemMXBean osBean
            = ManagementFactory.getPlatformMXBean(OperatingSystemMXBean.class);
        System.out.println("Total memory: "
            + osBean.getTotalPhysicalMemorySize() / (1024*1024)  +"MB");
        System.out.println("Free  memory: "
            + osBean.getFreePhysicalMemorySize() / (1024*1024)  +"MB");
    }
}