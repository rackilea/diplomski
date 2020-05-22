import com.sun.tools.attach.VirtualMachine;
import sun.tools.attach.HotSpotVirtualMachine;

import java.io.InputStream;

public class HeapDump {

    public static void main(String[] args) throws Exception {
        String pid = args[0];
        HotSpotVirtualMachine vm = (HotSpotVirtualMachine) VirtualMachine.attach(pid);

        try (InputStream in = vm.dumpHeap("/tmp/heapdump.hprof")) {
            byte[] buf = new byte[200];
            for (int bytes; (bytes = in.read(buf)) > 0; ) {
                System.out.write(buf, 0, bytes);
            }
        } finally {
            vm.detach();
        }
    }
}