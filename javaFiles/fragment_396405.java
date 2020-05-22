import java.lang.reflect.Field;
import java.net.NetworkInterface;
import java.util.Collections;
import java.util.List;

public class Test {
    public static void main(String[] args) throws Exception {
        List<NetworkInterface> netins = Collections.list(NetworkInterface.getNetworkInterfaces());
        for (NetworkInterface netin : netins) {
            System.out.println(netin + " " + netin.getIndex());
        }

        Field f = NetworkInterface.class.getDeclaredField("defaultIndex");
        f.setAccessible(true);
        System.out.println("defaultIndex = " + f.get(NetworkInterface.class));
    }
}