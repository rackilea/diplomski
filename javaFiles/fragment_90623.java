import sun.jvm.hotspot.runtime.VM;
import sun.jvm.hotspot.tools.Tool;

public class CompressedOopsInfo extends Tool {

    @Override
    public void run() {
        VM vm = VM.getVM();
        System.out.println("CompressedOops = " + vm.isCompressedOopsEnabled());
        System.out.println("CompressedClassPointers = " + vm.isCompressedKlassPointersEnabled());
        System.out.println("OOP base = 0x" + Long.toHexString(vm.getDebugger().getNarrowOopBase()));
        System.out.println("OOP shift = " + vm.getDebugger().getNarrowOopShift());
    }

    public static void main(String[] args) {
        new CompressedOopsInfo().execute(args);
    }
}