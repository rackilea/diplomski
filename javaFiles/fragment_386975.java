//@see http://linux.die.net/include/sys/ptrace.h
private static final int PTRACE_PEEKDATA = 2;
private static final int PTRACE_ATTACH = 16;
private static final int PTRACE_DETACH = 17;

public static void main(String[] args) {
    int pid = 1015;

    try {
        ptrace.ptrace(PTRACE_ATTACH, pid, null, null);
        Memory buffer = new Memory(4);
        ptrace.ptrace(PTRACE_PEEKDATA, pid, new Pointer(0x7f27d6575000L), buffer);
        System.out.println(buffer.getChar(0));
    } catch (LastErrorException ex) {
        ex.printStackTrace();
    } finally {
        ptrace.ptrace(PTRACE_DETACH, pid, null, null);
    }