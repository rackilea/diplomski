public class Test {

    private interface Kernel32 extends com.sun.jna.platform.win32.Kernel32 {

        Kernel32 INSTANCE = Native.load("kernel32", Kernel32.class, W32APIOptions.DEFAULT_OPTIONS);

        public Pointer VirtualAllocEx(HANDLE hProcess, Pointer lpAddress, SIZE_T dwSize, int flAllocationType, int flProtect);

        public boolean VirtualFreeEx(HANDLE hProcess, Pointer lpAddress, SIZE_T dwSize, int dwFreeType);

        int MEM_COMMIT = 0x00001000;
        int MEM_RESERVE = 0x00002000;
        int MEM_RESET = 0x00080000;
        int MEM_RESET_UNDO = 0x1000000;
        int MEM_LARGE_PAGES = 0x20000000;
        int MEM_PHYSICAL = 0x00400000;
        int MEM_TOP_DOWN = 0x00100000;
        int MEM_COALESCE_PLACEHOLDERS = 0x00000001;
        int MEM_PRESERVE_PLACEHOLDER = 0x00000002;
        int MEM_DECOMMIT = 0x4000;
        int MEM_RELEASE = 0x8000;
    }

    private static final int LVM_FIRST = 0x1000;
    private static final int LVM_GETITEMCOUNT = LVM_FIRST + 4;
    private static final int LVM_GETITEMPOSITION = LVM_FIRST + 16;

    public static void main(String[] args) throws IOException, InterruptedException {
        // Find the HWND for the "desktop" list view
        HWND hWnd_Progman = User32.INSTANCE.FindWindow("Progman", "Program Manager");
        HWND hWnd_SHELLDLL_DefView = User32.INSTANCE.FindWindowEx(hWnd_Progman, null, "SHELLDLL_DefView", null);
        HWND hWnd_SysListView32 = User32.INSTANCE.FindWindowEx(hWnd_SHELLDLL_DefView, null, "SysListView32", "FolderView");
        // Fetch the icon count
        int itemCount = User32.INSTANCE.SendMessage(hWnd_SysListView32, LVM_GETITEMCOUNT, new WPARAM(), new LPARAM()).intValue();
        System.out.println("Desktop Icons: " + itemCount);

        // Get the SysListView32 process handle.
        IntByReference processIdRef = new IntByReference();
        User32.INSTANCE.GetWindowThreadProcessId(hWnd_SysListView32, processIdRef);
        HANDLE procHandle = Kernel32.INSTANCE.OpenProcess(
                Kernel32.PROCESS_VM_OPERATION | Kernel32.PROCESS_VM_WRITE | Kernel32.PROCESS_VM_READ,
                false, processIdRef.getValue());

        // Allocate memory in the SysView32 process.
        int pointSize = new POINT().size(); // 8 bytes.
        Pointer pMem = Kernel32.INSTANCE.VirtualAllocEx(procHandle, null, new SIZE_T(pointSize),
                Kernel32.MEM_COMMIT, Kernel32.PAGE_READWRITE);

        for (int i = 0; i < itemCount; i++) {

            // Send the LVM_GETITEMPOSITION message to the SysListView32.
            LRESULT res = User32.INSTANCE.SendMessage(
                    hWnd_SysListView32, LVM_GETITEMPOSITION, new WPARAM(i), new LPARAM(Pointer.nativeValue(pMem)));

            if(res.intValue() != 1) {
                throw new IllegalStateException("Message sending failed");
            }

            // Read the earlier POINT-sized written memory.
            POINT point = new POINT();
            IntByReference read = new IntByReference();
            boolean success = Kernel32.INSTANCE.ReadProcessMemory(
                    procHandle, pMem, point.getPointer(), pointSize, read);

            if (!success) {
                System.out.println("Read error = " + Kernel32.INSTANCE.GetLastError());
                System.exit(1);
            }
            point.read();
            System.out.println("Point found: x=" + point.x + ", y=" + point.y);
        }

        // Release allocated memory
        Kernel32.INSTANCE.VirtualFreeEx(procHandle, pMem, new SIZE_T(0), Kernel32.MEM_RELEASE);

        // Close Process Handle
        Kernel32.INSTANCE.CloseHandle(procHandle);
    }
}