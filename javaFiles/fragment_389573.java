private static void testModuleFileName2(final int processId) {
    DWORD nSize = new DWORD(260);
    char lpFilename[] = new char[260];
    byte bFilename[] = new byte[260];

    DWORD options = new DWORD(Kernel32Me.PROCESS_VM_READ | Kernel32Me.PROCESS_QUERY_INFORMATION);
    DWORD procs = new DWORD(processId);

    HANDLE hProcess = Kernel32Me.INSTANCE.OpenProcess(options, false, procs);

    if (null == hProcess) {
        System.err.println("Can't have a handle for you..sorry");
        return;
    }

    HMODULE handle = Kernel32.INSTANCE.GetModuleHandle("kernel32.dll");

    if (null == handle) {
        System.err.println("Can't have a handle for you..sorry");
        return;
    }

    try {
        Kernel32Me.INSTANCE.GetModuleFileName(handle, lpFilename, nSize);
        System.err.println("2> module path is " + new String(lpFilename));

        Psapi.INSTANCE.GetModuleFileNameExA(hProcess, handle, bFilename, 260);
        System.err.println("2> module path is " + new String(bFilename));

        Psapi.INSTANCE.GetModuleFileNameExW(hProcess, null, lpFilename, 260);
        System.err.println("2> module path is " + new String(lpFilename));

    } finally {
        Kernel32Me.INSTANCE.CloseHandle(hProcess);
    }
}